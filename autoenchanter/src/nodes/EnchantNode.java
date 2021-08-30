package autoenchanter.src.nodes;

import autoenchanter.src.AutoEnchanter;
import dependencies.net.novakscripts.framework.Priority;
import dependencies.net.novakscripts.framework.regular.Node;
import org.osbot.rs07.api.ui.Tab;
import org.osbot.rs07.utility.ConditionalSleep;

public class EnchantNode extends Node {

    private AutoEnchanter script;

    public EnchantNode(AutoEnchanter script) {
        this.script = script;
    }

    @Override
    public boolean validate() {
        return script.getInventory().contains(script.getUserSettings().getItemToEnchant());
    }

    @Override
    public void execute() throws InterruptedException {
        if(script.getBank().isOpen() && script.getBank().close()) {
            new ConditionalSleep(5000) {
                @Override
                public boolean condition() throws InterruptedException {
                    return !script.getBank().isOpen();
                }
            }.sleep();
        } else {
            if(script.getMagic().isSpellSelected() && script.getInventory().deselectItem()) {
                new ConditionalSleep(5000) {
                    @Override
                    public boolean condition() throws InterruptedException {
                        return !script.getMagic().isSpellSelected();
                    }
                }.sleep();
            } else {
                if(script.getMagic().canCast(script.getUserSettings().getSpell())) {
                    if(script.getTabs().isOpen(Tab.MAGIC)) {
                        if (script.getMagic().castSpell(script.getUserSettings().getSpell()) && new ConditionalSleep(5000) {
                            @Override
                            public boolean condition() throws InterruptedException {
                                return script.getTabs().isOpen(Tab.INVENTORY);
                            }
                        }.sleep()) {
                            if(script.getInventory().interact("Cast", script.getUserSettings().getItemToEnchant())) {
                                script.addResourceGatered();
                                new ConditionalSleep(5000) {
                                    @Override
                                    public boolean condition() throws InterruptedException {
                                        return script.getTabs().isOpen(Tab.MAGIC) || script.getDialogues().isPendingContinuation();
                                    }
                                }.sleep();
                            }
                        }
                    } else {
                        if(script.getTabs().open(Tab.MAGIC)) {
                            new ConditionalSleep(5000) {
                                @Override
                                public boolean condition() throws InterruptedException {
                                    return script.getTabs().isOpen(Tab.MAGIC);
                                }
                            }.sleep();
                        }
                    }
                } else {
                    script.log("Ran out of runes!");
                    script.stop();
                }
            }
        }
    }

    @Override
    public Priority priority() {
        return Priority.VERY_LOW;
    }

    @Override
    public String getName() {
        return "Enchanting";
    }
}
