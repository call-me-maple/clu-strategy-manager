package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.transportation.Spellbook;
import cluestrategymanager.transportation.SpellbookTeleport;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Skill;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;

@Slf4j
public class ClueStrategyEditPanel extends JPanel
{
    private ClueStrategy clueStrategy;
    private ClueStrategyManagerPlugin plugin;
    private ClueTierPanel panel;
    private SpriteManager spriteManager;

    private final JComboBox<ComboBoxIconEntry> spellDropdown = new JComboBox<>();

    public ClueStrategyEditPanel(ClueStrategyManagerPlugin plugin, SpriteManager spriteManager, ClueTierPanel panel, ClueStrategy clueStrategy)
    {
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategy = clueStrategy;
        this.spriteManager = spriteManager;

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARKER_GRAY_COLOR);
        //setPreferredSize(new Dimension(Panel));

        final JComboBox<ComboBoxIconEntry> spellBookDropdown = new JComboBox<>();
        spellBookDropdown.setFocusable(false); // To prevent an annoying "focus paint" effect
        spellBookDropdown.setForeground(Color.WHITE);

        spellBookDropdown.setMaximumRowCount(Spellbook.values().length);
        final ComboBoxIconListRenderer spellbookRenderer = new ComboBoxIconListRenderer();
        spellbookRenderer.setDefaultText("Select a Spellbook...");
        spellBookDropdown.setRenderer(spellbookRenderer);

        for (final Spellbook spellbook : Spellbook.values())
        {
            spriteManager.getSpriteAsync(spellbook.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(new ImageIcon(sprite), spellbook.getName(), spellbook);
                spellBookDropdown.addItem(entry);
            });
        }

        spellBookDropdown.addItemListener(e ->
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

        spellBookDropdown.setSelectedIndex(-1);

        spellDropdown.setVisible(false);
        spellDropdown.setFocusable(false); // To prevent an annoying "focus paint" effect
        spellDropdown.setForeground(Color.WHITE);
        spellDropdown.setMaximumRowCount(10);
        spellDropdown.setSelectedIndex(-1);
        final ComboBoxIconListRenderer spellRenderer = new ComboBoxIconListRenderer();
        spellRenderer.setDefaultText("Select a Spell...");
        spellDropdown.setRenderer(spellRenderer);
        spellDropdown.addItemListener(e ->
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final ComboBoxIconEntry source = (ComboBoxIconEntry) e.getItem();
                if (source.getData() instanceof SpellbookTeleport)
                {
                    final SpellbookTeleport teleport = (SpellbookTeleport) source.getData();
                    log.debug("selected tele: {}", teleport);
                }
            }
        });

        add(spellBookDropdown, BorderLayout.CENTER);
        add(spellDropdown, BorderLayout.SOUTH);


    }

    private void selectSpell(Spellbook spellbook)
    {
        spellDropdown.removeAllItems();
        for (final SpellbookTeleport teleport : SpellbookTeleport.TELEPORT_MAP.get(spellbook))
        {
            spriteManager.getSpriteAsync(teleport.getSpriteID(), 0, sprite ->
            {
                final ComboBoxIconEntry entry = new ComboBoxIconEntry(new ImageIcon(sprite), teleport.getName(), teleport);
                spellDropdown.addItem(entry);
            });
        }

        spellDropdown.setSelectedIndex(-1);
        spellDropdown.setVisible(true);
    }
}
