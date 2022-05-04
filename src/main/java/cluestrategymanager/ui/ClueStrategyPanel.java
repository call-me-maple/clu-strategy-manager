package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.FlatTextField;
import net.runelite.client.util.ImageUtil;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@Slf4j
public class ClueStrategyPanel extends JPanel
{	private static final Border NAME_BOTTOM_BORDER = new CompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
        BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR));

    private static ImageIcon YES_ICON;
    private static ImageIcon YES_HOVER_ICON;
    private static ImageIcon NO_ICON;
    private static ImageIcon NO_HOVER_ICON;

    private final JLabel completableLabel = new JLabel();
    private final JLabel editLabel = new JLabel("Edit");
    private final FlatTextField nameInput = new FlatTextField();

    private ClueStrategy clueStrategy;
    private ClueStrategyManagerPlugin plugin;
    private ClueTierPanel panel;

    static
    {
        final BufferedImage yesIcon = ImageUtil.loadImageResource(ClueStrategyManagerPlugin.class, "/yes_emote_icon.png");
        YES_ICON = new ImageIcon(yesIcon);
        YES_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(yesIcon, 0.53f));

        final BufferedImage noIcon = ImageUtil.loadImageResource(ClueStrategyManagerPlugin.class, "/no_emote_icon.png");
        //final BufferedImage compactIconHover = ImageUtil.luminanceOffset(compactIcon, -150);
        NO_ICON = new ImageIcon(noIcon);
        NO_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(noIcon, 0.53f));
    }
    public ClueStrategyPanel(ClueStrategyManagerPlugin plugin, ClueTierPanel panel, ClueStrategy clueStrategy)
    {
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategy = clueStrategy;

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        //JPanel nameWrapper = new JPanel(new BorderLayout());
        //nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        //nameWrapper.setBorder(NAME_BOTTOM_BORDER);

        JPanel nameActions = new JPanel(new BorderLayout(3, 0));
        nameActions.setBorder(new EmptyBorder(0, 0, 0, 8));
        nameActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        completableLabel.setVisible(true);
        completableLabel.setFont(FontManager.getRunescapeSmallFont());
        completableLabel.setIcon(clueStrategy.isCompletable() ? YES_ICON: NO_ICON);
        completableLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                //TODO in config toggle completable
                clueStrategy.setCompletable(!clueStrategy.isCompletable());
                panel.build();
                log.debug("toogled complete cluestrat {}", clueStrategy);
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                completableLabel.setIcon(clueStrategy.isCompletable() ? YES_HOVER_ICON: NO_HOVER_ICON);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                completableLabel.setIcon(clueStrategy.isCompletable() ? YES_ICON: NO_ICON);
            }
        });

        editLabel.setVisible(true);
        editLabel.setFont(FontManager.getRunescapeSmallFont());
        editLabel.setForeground(ColorScheme.GRAND_EXCHANGE_LIMIT);
        editLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                //open clue strat edit panel
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                editLabel.setForeground(ColorScheme.GRAND_EXCHANGE_LIMIT.darker());
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                editLabel.setForeground(ColorScheme.GRAND_EXCHANGE_LIMIT);
            }
        });

        nameActions.add(completableLabel, BorderLayout.CENTER);
        nameActions.add(editLabel, BorderLayout.WEST);

        nameInput.setText(clueStrategy.getClue().getClueText());
        nameInput.setBorder(null);
        nameInput.setEditable(false);
        nameInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        nameInput.setPreferredSize(new Dimension(0, 24));
        nameInput.getTextField().setForeground(Color.WHITE);
        nameInput.getTextField().setBorder(new EmptyBorder(0, 8, 0, 0));

        //nameWrapper.add(nameInput, BorderLayout.CENTER);
        //nameWrapper.add(nameActions, BorderLayout.EAST);

        //add(nameWrapper, BorderLayout.NORTH);

        add(nameInput, BorderLayout.CENTER);
        add(nameActions, BorderLayout.EAST);
    }
}
