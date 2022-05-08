package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.transportation.*;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.util.AsyncBufferedImage;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ItemEvent;

@Slf4j
public class ClueStrategyEditPanel extends JPanel
{
    private static final int COMBO_BOX_SPRITE_WIDTH = 20;
    private static final int COMBO_BOX_SPRITE_HEIGHT = 20;

    private final ClueStrategy clueStrategy;
    private final ClueStrategyManagerPlugin plugin;
    private final ClueTierPanel panel;
    private final SpriteManager spriteManager;

    private final JComboBox<ComboBoxIconEntry> transportationDropdown;

    private final JComboBox<ComboBoxIconEntry> spellbookDropdown;
    private final JComboBox<ComboBoxIconEntry> minigameDropdown;
    private final JComboBox<ComboBoxIconEntry> pohDropdown;
    private final JComboBox<ComboBoxIconEntry> itemDropdown;

    private final static String SPELLBOOK_DROPDOWN_NAME = "SPELLBOOK_DROPDOWN";
    private final static String MINIGAME_DROPDOWN_NAME = "MINIGAME_DROPDOWN";
    private final static String POH_DROPDOWN_NAME = "POH_DROPDOWN";
    private final static String ITEM_DROPDOWN_NAME = "ITEM_DROPDOWN";
    private final static String SPELL_DROPDOWN_NAME = "SPELL_DROPDOWN";

    private final CardLayout dropdownOneLayout = new CardLayout();
    private final JPanel dropdownOneContainer = new JPanel(dropdownOneLayout);

    private final CardLayout dropdownTwoLayout = new CardLayout();
    private final JPanel dropdownTwoContainer = new JPanel(dropdownTwoLayout);

    private final JComboBox<ComboBoxIconEntry> spellDropdown;

    public ClueStrategyEditPanel(ClueStrategyManagerPlugin plugin, ItemManager itemManager, SpriteManager spriteManager, ClueTierPanel panel, ClueStrategy clueStrategy)
    {
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategy = clueStrategy;
        this.spriteManager = spriteManager;

        setLayout(new GridBagLayout());

        transportationDropdown = new ComboBoxIcon("Select a Transport...");
        for (final Transportation transportation : Transportation.values())
        {
            spriteManager.getSpriteAsync(transportation.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                        transportation.getName(),
                        transportation
                );
                transportationDropdown.addItem(entry);
            });
        }
        transportationDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof Transportation)
                {
                    final Transportation transportation = (Transportation) source.getData();
                    log.debug("selected sb: {}", transportation);
                    selectTransportation(transportation);
                }
            }
        });

        spellbookDropdown = new ComboBoxIcon("Select a Spellbook...");
        for (final Spellbook spellbook : Spellbook.values())
        {
            spriteManager.getSpriteAsync(spellbook.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                        spellbook.getName(),
                        spellbook
                );
                spellbookDropdown.addItem(entry);
            });
        }
        spellbookDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof Spellbook)
                {
                    final Spellbook spellbook = (Spellbook) source.getData();
                    log.debug("selected sb: {}", spellbook);
                    selectSpell(spellbook);
                }
            }
        });

        minigameDropdown = new ComboBoxIcon("Select a Minigame...");
        for (MinigameTeleport minigameTeleport : MinigameTeleport.values())
        {
            AsyncBufferedImage icon = itemManager.getImage(minigameTeleport.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        minigameTeleport.getName(),
                        minigameTeleport
                );
                minigameDropdown.addItem(entry);
            });
        }

        pohDropdown = new ComboBoxIcon("Select a POH Teleport...");
        for (final PohTeleport pohTele : PohTeleport.values())
        {
            AsyncBufferedImage icon = itemManager.getImage(pohTele.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        pohTele.getName(),
                        pohTele
                );
                pohDropdown.addItem(entry);
            });
        }

        itemDropdown = new ComboBoxIcon("Select an Item...");
        for (final ItemTeleport itemTeleport : ItemTeleport.values())
        {
            AsyncBufferedImage icon = itemManager.getImage(itemTeleport.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        itemTeleport.getName(),
                        itemTeleport
                );
                itemDropdown.addItem(entry);
            });
        }
        AutoCompletion.enable(itemDropdown);
        itemDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof ItemTeleport)
                {
                    final ItemTeleport teleport = (ItemTeleport) source.getData();
                    log.debug("selected item tele: {}", teleport);
                    //((ComboBoxIcon) itemDropdown).setIcon(source.getIcon());
                }
            }
        });

        dropdownOneContainer.add(spellbookDropdown, SPELLBOOK_DROPDOWN_NAME);
        dropdownOneContainer.add(minigameDropdown, MINIGAME_DROPDOWN_NAME);
        dropdownOneContainer.add(pohDropdown, POH_DROPDOWN_NAME);
        dropdownOneContainer.add(itemDropdown, ITEM_DROPDOWN_NAME);
        dropdownOneContainer.setVisible(false);


        spellDropdown = new ComboBoxIcon("Select a Spell...");
        spellDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof SpellbookTeleport)
                {
                    final SpellbookTeleport teleport = (SpellbookTeleport) source.getData();
                    log.debug("selected spell tele: {}", teleport);
                }
            }
        });

        dropdownTwoContainer.add(spellDropdown, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(false);

        //resetDropdowns();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipady = 5;

        // Transportation dropdown
        add(transportationDropdown, constraints);
        transportationDropdown.setSelectedIndex(-1);
        constraints.gridy++;

        // Spacing
        add(Box.createRigidArea(new Dimension(0, 4)), constraints);
        constraints.gridy++;

        // 1st row dropdowns
        add(dropdownOneContainer, constraints);

        constraints.gridy++;
        // Spacing
        add(Box.createRigidArea(new Dimension(0, 4)), constraints);
        constraints.gridy++;

        // 2nd row dropdowns
        add(dropdownTwoContainer, constraints);
        constraints.gridy++;
    }

    private void selectTransportation(Transportation transportation)
    {
        //resetDropdowns();
        dropdownOneContainer.setVisible(true);
        dropdownTwoContainer.setVisible(false);

        switch (transportation)
        {
            case SPELLBOOK_TELEPORT:
                dropdownOneLayout.show(dropdownOneContainer, SPELLBOOK_DROPDOWN_NAME);
                break;
            case MINIGAME_TELEPORT:
                dropdownOneLayout.show(dropdownOneContainer, MINIGAME_DROPDOWN_NAME);
                break;
            case ITEM_TELEPORT:
                dropdownOneLayout.show(dropdownOneContainer, ITEM_DROPDOWN_NAME);
                break;
            case MAP_TRANSPORTATION:
                break;
            case PLAYER_OWNED_HOUSE:
                dropdownOneLayout.show(dropdownOneContainer, POH_DROPDOWN_NAME);
                break;
        }
    }


    private void selectSpell(Spellbook spellbook)
    {
        spellDropdown.removeAllItems();
        for (final SpellbookTeleport teleport : SpellbookTeleport.TELEPORT_MAP.get(spellbook))
        {
            spriteManager.getSpriteAsync(teleport.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                        teleport.getName(),
                        teleport
                );
                spellDropdown.addItem(entry);
            });
        }

        spellDropdown.setSelectedIndex(-1);
        dropdownTwoLayout.show(dropdownTwoContainer, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(true);
    }
}
