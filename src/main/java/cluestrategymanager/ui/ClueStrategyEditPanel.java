package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.data.transportation.*;
import cluestrategymanager.ui.combobox.ComboBoxIcon;
import cluestrategymanager.ui.combobox.ComboBoxIconEntry;
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
    private final JComboBox<ComboBoxIconEntry> fairyRingDropdown;
    private final JComboBox<ComboBoxIconEntry> spiritTreeDropdown;

    private final static String SPELLBOOK_DROPDOWN_NAME = "SPELLBOOK_DROPDOWN";
    private final static String GROUPING_DROPDOWN_NAME = "GROUPING_DROPDOWN";
    private final static String POH_DROPDOWN_NAME = "POH_DROPDOWN";
    private final static String ITEM_DROPDOWN_NAME = "ITEM_DROPDOWN";
    private final static String SPELL_DROPDOWN_NAME = "SPELL_DROPDOWN";
    private final static String FAIRY_RING_DROPDOWN_NAME = "FAIRY_RING_DROPDOWN";
    private final static String SPIRIT_TREE_DROPDOWN_NAME = "SPIRIT_TREE_DROPDOWN";

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

        // Transportation Methods Dropdown (1st row)
        transportationDropdown = new ComboBoxIcon("Select a Transport...");
        for (final TransportationMethod transportation : TransportationMethod.values())
        {
            if (transportation.getSpriteID() != -1)
            {
                createSpriteEntry(transportation, transportationDropdown, transportation.getSpriteID());
            }
            else if (transportation.getItemID() != -1)
            {
                createItemEntry(transportation, transportationDropdown, transportation.getItemID());
            }
        }
        transportationDropdown.addItemListener(this::entrySelected);

        // Spellbook Dropdown (2nd row)
        spellbookDropdown = new ComboBoxIcon("Select a Spellbook...");
        for (final Spellbook spellbook : Spellbook.values())
        {
            createSpriteEntry(spellbook, spellbookDropdown, spellbook.getSpriteID());
        }
        spellbookDropdown.addItemListener(this::entrySelected);

        // Grouping Dropdown (2nd row)
        groupingDropdown = new ComboBoxIcon("Select a Grouping...");
        for (Grouping grouping : Grouping.values())
        {
            createItemEntry(grouping, groupingDropdown, grouping.getItemID());
        }
        groupingDropdown.addItemListener(this::entrySelected);

        // Poh Method Dropdown (2nd row)
        pohDropdown = new ComboBoxIcon("Select a POH Teleport...");
        for (final PohTeleport pohTele : PohTeleport.values())
        {
            createItemEntry(pohTele, pohDropdown, pohTele.getItemID());
        }
        pohDropdown.addItemListener(this::entrySelected);

        // Teleport Item Dropdown (2nd row)
        itemDropdown = new ComboBoxIcon("", true, true);
        for (final TeleportItem teleportItem : TeleportItem.values())
        {
            createItemEntry(teleportItem, itemDropdown, teleportItem.getItemID());
        }
        itemDropdown.addItemListener(this::entrySelected);

        // Fairy Ring Dropdown (2nd row)
        fairyRingDropdown = new ComboBoxIcon("Select a Fairy Ring...");
        for (final FairyRing fairyRing : FairyRing.values())
        {
            createItemEntry(fairyRing, fairyRingDropdown, fairyRing.getItemID());
        }
        fairyRingDropdown.addItemListener(this::entrySelected);

        // Spirit Tree Dropdown (2nd row)
        spiritTreeDropdown = new ComboBoxIcon("Select a Spirit Tree...");
        for (final SpiritTree spiritTree : SpiritTree.values())
        {
            createItemEntry(spiritTree, spiritTreeDropdown, spiritTree.getItemID());
        }
        spiritTreeDropdown.addItemListener(this::entrySelected);

        // Transportation Dropdown (3rd row)
        teleportDropdown = new ComboBoxIcon("Select a Teleport...");
        teleportDropdown.setEnabled(true);
        teleportDropdown.addItemListener(this::entrySelected);

        dropdownOneContainer.add(spellbookDropdown, SPELLBOOK_DROPDOWN_NAME);
        dropdownOneContainer.add(groupingDropdown, GROUPING_DROPDOWN_NAME);
        dropdownOneContainer.add(pohDropdown, POH_DROPDOWN_NAME);
        dropdownOneContainer.add(itemDropdown, ITEM_DROPDOWN_NAME);
        dropdownOneContainer.add(fairyRingDropdown, FAIRY_RING_DROPDOWN_NAME);
        dropdownOneContainer.add(spiritTreeDropdown, SPIRIT_TREE_DROPDOWN_NAME);
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

    private void createItemEntry(Object o, JComboBox<ComboBoxIconEntry> dropdown, int itemID)
    {
        AsyncBufferedImage icon = itemManager.getImage(itemID);
        icon.onLoaded(() ->
        {
            final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                    new ImageIcon(icon.getScaledInstance(COMBO_BOX_SPRITE_WIDTH+5, COMBO_BOX_SPRITE_HEIGHT+5, Image.SCALE_SMOOTH)),
                    o.toString(),
                    o
            );
            dropdown.addItem(entry);
        });
    }

    private void createSpriteEntry(Object o, JComboBox<ComboBoxIconEntry> dropdown, int spriteID)
    {
        spriteManager.getSpriteAsync(spriteID, 0, sprite ->
        {
            final ComboBoxIconEntry entry = new ComboBoxIconEntry(
                    new ImageIcon(sprite.getScaledInstance(COMBO_BOX_SPRITE_WIDTH, COMBO_BOX_SPRITE_HEIGHT, Image.SCALE_SMOOTH)),
                    o.toString(),
                    o
            );
            dropdown.addItem(entry);
        });
    }

    private void entrySelected(ItemEvent itemEvent)
    {
        if (itemEvent.getStateChange() == ItemEvent.SELECTED)
        {
            if (!(itemEvent.getItem() instanceof ComboBoxIconEntry))
            {
                log.error("selected not a ComboboxEntry??? {}", itemEvent.getItem());
                return;
            }

            final ComboBoxIconEntry source = (ComboBoxIconEntry) itemEvent.getItem();
            Object data = source.getData();
            if (data instanceof SpiritTree)
            {
                final SpiritTree item = (SpiritTree) data;
                log.debug("selected spirit tree tele: {}", item);
                log.debug("teles? {}", Transportation.SPIRIT_TREE_TELEPORT_MAP.get(item));
                updateTeleportDropdown(Transportation.SPIRIT_TREE_TELEPORT_MAP.get(item));
            }
            else if (data instanceof FairyRing)
            {
                final FairyRing item = (FairyRing) data;
                log.debug("selected fairy ring tele: {}", item);
                log.debug("teles? {}", Transportation.FAIRY_RING_TELEPORT_MAP.get(item));
                // updateEditorIcon(source);
                updateTeleportDropdown(Transportation.FAIRY_RING_TELEPORT_MAP.get(item));
            }
            else if (data instanceof TeleportItem)
            {
                final TeleportItem item = (TeleportItem) data;
                log.debug("selected item tele: {}", item);
                log.debug("teles? {}", Transportation.ITEM_TELEPORT_MAP.get(item));
                updateEditorIcon(itemDropdown, source);
                updateTeleportDropdown(Transportation.ITEM_TELEPORT_MAP.get(item));
            }
            else if (data instanceof PohTeleport)
            {
                final PohTeleport pohTeleport = (PohTeleport) data;
                log.debug("selected poh tele: {}", pohTeleport);
                log.debug("teles? {}", Transportation.POH_TELEPORT_MAP.get(pohTeleport));
                updateTeleportDropdown(Transportation.POH_TELEPORT_MAP.get(pohTeleport));
            }
            else if (data instanceof Grouping)
            {
                final Grouping grouping = (Grouping) data;
                log.debug("selected item tele: {}", grouping);
                ///selectGrouping(grouping);
                updateTeleportDropdown(Transportation.GROUPING_TELEPORT_MAP.get(grouping));
            }
            else if (data instanceof Spellbook)
            {
                final Spellbook spellbook = (Spellbook) data;
                log.debug("selected sb: {}", spellbook);
                updateTeleportDropdown(Transportation.SPELLBOOK_TELEPORT_MAP.get(spellbook));
            }
            else if (data instanceof Transportation)
            {
                final Transportation transportation = (Transportation) data;
                log.debug("selected tele: {}", transportation);
            }
            else if (data instanceof TransportationMethod)
            {
                final TransportationMethod transportation = (TransportationMethod) data;
                log.debug("selected sb: {}", transportation);
                selectTransportationMethod(transportation);
            }
        }
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


    private void updateEditorIcon(JComboBox<ComboBoxIconEntry> dropdown, ComboBoxIconEntry entry)
    {
        ComboBoxEditor editor = dropdown.getEditor();
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
            case FAIRY_RING:
                dropdownOneLayout.show(dropdownOneContainer, FAIRY_RING_DROPDOWN_NAME);
                break;
            case SPIRIT_TREE:
                dropdownOneLayout.show(dropdownOneContainer, SPIRIT_TREE_DROPDOWN_NAME);
                break;
        }
    }

    private void updateTeleportDropdown(ImmutableCollection<Transportation> transportations)
    {
        teleportDropdown.removeAllItems();
        teleportDropdown.setSelectedIndex(-1);

        for (final Transportation transportation : transportations)
        {
            teleportDropdown.addItem(teleportEntries.get(transportation));
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
}
