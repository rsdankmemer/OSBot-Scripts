package autoenchanter.src;

import autoenchanter.src.data.UnenchantedItem;
import autoenchanter.src.nodes.BankNode;
import autoenchanter.src.nodes.EnchantNode;
import autoenchanter.src.settings.UserSettings;
import dependencies.net.novakscripts.framework.regular.Controller;
import dependencies.net.novakscripts.framework.regular.Node;
import dependencies.net.novakscripts.utils.Painter;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;

@ScriptManifest(info = "Auto Enchanter ", name = "Auto Enchanter Pro", logo = "", version = 1.00, author = "Novak")
public class AutoEnchanter extends Script {

    private Controller controller;
    private Painter painter;
    private Painter.PaintProperty time, status, exp, level, totalResources;
    private long startTime;
    private int startExp, resourcesGathered;
    private UserSettings userSettings;

    private String currentStatus = "";

    public AutoEnchanter() {
        time = new Painter.PaintProperty();
        status = new Painter.PaintProperty();
        exp = new Painter.PaintProperty();
        level = new Painter.PaintProperty();
        totalResources = new Painter.PaintProperty();
        userSettings = new UserSettings();
        controller = new Controller();
    }

    @Override
    public void onStart() throws InterruptedException {
        painter = new Painter(getName(), String.valueOf(getVersion()), new Color(43, 43, 43), new Color(145, 213, 255));
        for(int i = 0; i < UnenchantedItem.values().length; i++) {
            if(getInventory().contains(UnenchantedItem.values()[i].toString())) {
                userSettings.setSpell(UnenchantedItem.values()[i].getEnchantSpell());
                userSettings.setItemToEnchant(UnenchantedItem.values()[i].toString());
                userSettings.setEnchantedItem(UnenchantedItem.values()[i].getEnchantedItem().toString());
                break;
            }
        }
        controller.addNodes(new BankNode(this), new EnchantNode(this));
        startTime = System.currentTimeMillis();
        startExp = getSkills().getExperience(Skill.MAGIC);
    }

    @Override
    public int onLoop() throws InterruptedException {
        Node n = controller.getCurrentNode();
        if(n != null) {
            currentStatus = n.getName();
            n.execute();
        }
        return 50;
    }

    @Override
    public void onMessage(Message m) throws InterruptedException {

    }

    @Override
    public void onExit() throws InterruptedException {

    }

    @Override
    public void onPaint(Graphics2D g) {
        long timeElapsed = System.currentTimeMillis() - startTime;
        int expGained = getSkills().getExperience(Skill.MAGIC) - startExp;
        painter.properties(
                time.value("Time Running: " + painter.formatTime(timeElapsed)),
                status.value("Status: " + currentStatus),
                exp.value("Exp Gained: " + expGained + " (" + painter.getHourly(expGained, timeElapsed) + ")"),
                level.value("Level: " + getSkills().getStatic(Skill.MAGIC)),
                totalResources.value("Items Enchanted: " + resourcesGathered + " (" + painter.getHourly(resourcesGathered, timeElapsed) + ")")
        ).draw(g);
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public Controller getController() {
        return controller;
    }

    public int addResourceGatered() {
        return resourcesGathered++;
    }

}

