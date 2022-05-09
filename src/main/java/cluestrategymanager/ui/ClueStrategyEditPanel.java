package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.transportation.*;
import com.google.common.collect.ImmutableCollection;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.util.AsyncBufferedImage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ClueStrategyEditPanel extends JPanel
{
    private static final int COMBO_BOX_SPRITE_WIDTH = 20;
    private static final int COMBO_BOX_SPRITE_HEIGHT = 20;

    private final ClueStrategy clueStrategy;
    private final ClueStrategyManagerPlugin plugin;
    private final ClueTierPanel panel;
    private final SpriteManager spriteManager;
    private final ItemManager itemManager;

    private Map<Transportation, ComboBoxIconEntry> teleportEntries;

    private final JComboBox<ComboBoxIconEntry> transportationDropdown;

    private final JComboBox<ComboBoxIconEntry> spellbookDropdown;
    private final JComboBox<ComboBoxIconEntry> groupingDropdown;
    private final JComboBox<ComboBoxIconEntry> pohDropdown;
    private final JComboBox<ComboBoxIconEntry> itemDropdown;

    private final static String SPELLBOOK_DROPDOWN_NAME = "SPELLBOOK_DROPDOWN";
    private final static String GROUPING_DROPDOWN_NAME = "GROUPING_DROPDOWN";
    private final static String POH_DROPDOWN_NAME = "POH_DROPDOWN";
    private final static String ITEM_DROPDOWN_NAME = "ITEM_DROPDOWN";
    private final static String SPELL_DROPDOWN_NAME = "SPELL_DROPDOWN";

    private final CardLayout dropdownOneLayout = new CardLayout();
    private final JPanel dropdownOneContainer = new JPanel(dropdownOneLayout);

    private final CardLayout dropdownTwoLayout = new CardLayout();
    private final JPanel dropdownTwoContainer = new JPanel(dropdownTwoLayout);

    private final JComboBox<ComboBoxIconEntry> teleportDropdown;
    private boolean init;

    public ClueStrategyEditPanel(ClueStrategyManagerPlugin plugin, ItemManager itemManager, SpriteManager spriteManager, ClueTierPanel panel, ClueStrategy clueStrategy)
    {
        init = true;
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategy = clueStrategy;
        this.spriteManager = spriteManager;
        this.itemManager = itemManager;

        setLayout(new GridBagLayout());

        loadTeleports();
        transportationDropdown = new ComboBoxIcon("Select a Transport...");
        for (final TransportationMethod transportation : TransportationMethod.values())
        {
            spriteManager.getSpriteAsync(transportation.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                        transportation.getName(),
                        transportation
                );
                transportationDropdown.addItem(entry);

                if (clueStrategy.getTransportation() != null && clueStrategy.getTransportation().getTransportationMethod() == transportation)
                {
                    transportationDropdown.setSelectedItem(entry);
                }
            });
        }
        transportationDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof TransportationMethod)
                {
                    final TransportationMethod transportation = (TransportationMethod) source.getData();
                    log.debug("selected sb: {}", transportation);
                    selectTransportationMethod(transportation);
                }
            }
        });

        teleportDropdown = new ComboBoxIcon("Select a Teleport...");
        teleportDropdown.setEnabled(true);
        teleportDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof Transportation)
                {
                    final Transportation transportation = (Transportation) source.getData();
                    log.debug("selected tele: {}", transportation);
                    //clueStrategy.setTransportation(transportation);
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

                if (clueStrategy.getTransportation() != null && clueStrategy.getTransportation().getSpellbook() == spellbook)
                {
                    spellbookDropdown.setSelectedItem(entry);
                }
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
                    //selectSpell(spellbook);
                    updateTeleportDropdown(Transportation.SPELLBOOK_TELEPORT_MAP.get(spellbook));
                }
            }
        });

        groupingDropdown = new ComboBoxIcon("Select a Grouping...");
        for (Grouping grouping : Grouping.values())
        {
            AsyncBufferedImage icon = itemManager.getImage(grouping.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        grouping.getName(),
                        grouping
                );
                groupingDropdown.addItem(entry);

                if (clueStrategy.getTransportation() != null && clueStrategy.getTransportation().getGrouping() == grouping)
                {
                    groupingDropdown.setSelectedItem(entry);
                }
            });
        }
        groupingDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof Grouping)
                {
                    final Grouping grouping = (Grouping) source.getData();
                    log.debug("selected item tele: {}", grouping);
                    ///selectGrouping(grouping);
                    updateTeleportDropdown(Transportation.GROUPING_TELEPORT_MAP.get(grouping));
                }
            }
        });

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

                //if (clueStrategy.getTransportation() != null && clueStrategy.get().getPohTeleport() == pohTele)
                //{
                //    pohDropdown.setSelectedItem(entry);
                //}
            });
        }

        itemDropdown = new ComboBoxIcon("Select an Item...");
        for (final TeleportItem teleportItem : TeleportItem.values())
        {
            AsyncBufferedImage icon = itemManager.getImage(teleportItem.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        teleportItem.getName(),
                        teleportItem
                );
                itemDropdown.addItem(entry);

                if (clueStrategy.getTransportation() != null && clueStrategy.getTransportation().getTeleportItem() == teleportItem)
                {
                    itemDropdown.setSelectedItem(entry);
                }
            });
        }
        AutoCompletion.enable(itemDropdown);
        itemDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof TeleportItem)
                {
                    final TeleportItem item = (TeleportItem) source.getData();
                    log.debug("selected item tele: {}", item);
                    log.debug("teles? {}", Transportation.ITEM_TELEPORT_MAP.get(item));
                    updateEditorIcon(source);
                    // selectItem(item);
                    updateTeleportDropdown(Transportation.ITEM_TELEPORT_MAP.get(item));
                }
            }
        });


        dropdownOneContainer.add(spellbookDropdown, SPELLBOOK_DROPDOWN_NAME);
        dropdownOneContainer.add(groupingDropdown, GROUPING_DROPDOWN_NAME);
        dropdownOneContainer.add(pohDropdown, POH_DROPDOWN_NAME);
        dropdownOneContainer.add(itemDropdown, ITEM_DROPDOWN_NAME);
        dropdownOneContainer.setVisible(false);

        dropdownTwoContainer.add(teleportDropdown, SPELL_DROPDOWN_NAME);
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

        init = false;
    }

    private void loadTeleports()
    {
        teleportEntries = new HashMap<>();
        for (Transportation transportation : Transportation.values())
        {
            if (transportation.getItemID() != -1)
            {
                AsyncBufferedImage icon = itemManager.getImage(transportation.getItemID());
                icon.onLoaded(() ->
                {
                    final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                            new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                            transportation.getName(),
                            transportation
                    );
                    teleportEntries.put(transportation, entry);
                });
            }
            else if (transportation.getSpriteID() != -1)
            {
                spriteManager.getSpriteAsync(transportation.getSpriteID(), 0, sprite ->
                {
                    final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                            new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                            transportation.getName(),
                            transportation
                    );
                    teleportEntries.put(transportation, entry);
                });
            }
            else
            {
                log.debug("no icon for {}", transportation);
            }
        }
        // TODO how to wait?
    }


    private void updateEditorIcon(ComboBoxIconEntry entry)
    {
        ComboBoxEditor editor = itemDropdown.getEditor();
        JTextField textField = (JTextField) editor.getEditorComponent();

        Border currentBorder = textField.getBorder();
        // MatteBorder wants to tile the icon
        Border iconBorder = new MatteBorder(0, entry.getIcon().getIconWidth(), 0, 0, entry.getIcon());
        if (currentBorder instanceof  CompoundBorder)
        {
            currentBorder = ((CompoundBorder) currentBorder).getOutsideBorder();
        }
        textField.setBorder(new CompoundBorder(currentBorder, iconBorder));
    }

    private void selectTransportationMethod(TransportationMethod transportation)
    {
        //resetDropdowns();
        dropdownOneContainer.setVisible(true);
        dropdownTwoContainer.setVisible(false);

        switch (transportation)
        {
            case SPELLBOOK_TELEPORT:
                dropdownOneLayout.show(dropdownOneContainer, SPELLBOOK_DROPDOWN_NAME);
                break;
            case GROUPING_TELEPORT:
                dropdownOneLayout.show(dropdownOneContainer, GROUPING_DROPDOWN_NAME);
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
        teleportDropdown.removeAllItems();
        for (final Transportation transportation : Transportation.SPELLBOOK_TELEPORT_MAP.get(spellbook))
        {
            spriteManager.getSpriteAsync(transportation.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                        transportation.getName(),
                        transportation
                );
                teleportDropdown.addItem(entry);
            });
        }

        teleportDropdown.setSelectedIndex(-1);
        dropdownTwoLayout.show(dropdownTwoContainer, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(true);
    }

    private void selectGrouping(Grouping grouping)
    {
        teleportDropdown.removeAllItems();
        for (final Transportation transportation : Transportation.GROUPING_TELEPORT_MAP.get(grouping))
        {
            AsyncBufferedImage icon = itemManager.getImage(transportation.getItemID());
            icon.onLoaded(() ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                        new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                        transportation.getName(),
                        transportation
                );
                teleportDropdown.addItem(entry);
            });
        }

        teleportDropdown.setSelectedIndex(-1);
        dropdownTwoLayout.show(dropdownTwoContainer, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(true);
    }

    private void updateTeleportDropdown(ImmutableCollection<Transportation> transportations)
    {
        teleportDropdown.removeAllItems();
        teleportDropdown.setSelectedIndex(-1);

        for (final Transportation transportation : transportations)
        {
            teleportDropdown.addItem(teleportEntries.get(transportation));
            if (init && clueStrategy.getTransportation() != null && transportation == clueStrategy.getTransportation())
            {
                teleportDropdown.setSelectedItem(teleportEntries.get(transportation));
            }
        }
        dropdownTwoLayout.show(dropdownTwoContainer, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(true);
        teleportDropdown.setEnabled(true);


        // TODO Hide if there is only 1 options but still select the teleport
        if (transportations.size() == 1)
        {
            teleportDropdown.setSelectedIndex(0);
            teleportDropdown.setEnabled(false);
        }
    }

    private void selectItem(TeleportItem item)
    {
        teleportDropdown.removeAllItems();
        for (final Transportation transportation : Transportation.ITEM_TELEPORT_MAP.get(item))
        {
            teleportDropdown.addItem(teleportEntries.get(transportation));
        }

        teleportDropdown.setSelectedIndex(-1);
        dropdownTwoLayout.show(dropdownTwoContainer, SPELL_DROPDOWN_NAME);
        dropdownTwoContainer.setVisible(true);
    }

}
