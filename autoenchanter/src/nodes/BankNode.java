package autoenchanter.src.nodes;

import autoenchanter.src.AutoEnchanter;
import dependencies.net.novakscripts.framework.Priority;
import dependencies.net.novakscripts.framework.regular.Node;
import org.osbot.rs07.utility.ConditionalSleep;

public class BankNode extends Node {

    private AutoEnchanter script;

    public BankNode(AutoEnchanter script) {
        this.script = script;
    }

    @Override
    public boolean validate() {
        return !script.getInventory().contains(script.getUserSettings().getItemToEnchant());
    }

    @Override
    public void execute() throws InterruptedException {
        if(script.getMagic().isSpellSelected()) {
            if(script.getMagic().deselectSpell()) {
                new ConditionalSleep(5000) {
                    @Override
                    public boolean condition() throws InterruptedException {
                        return !script.getMagic().isSpellSelected();
                    }
                }.sleep();
            }
        } else {
            if(script.getBank().isOpen()) {
                if(script.getInventory().contains(script.getUserSettings().getEnchantedItem())) {
                    if(script.getBank().depositAll(script.getUserSettings().getEnchantedItem())) {
                        new ConditionalSleep(5000) {
                            @Override
                            public boolean condition() throws InterruptedException {
                                return !script.getInventory().contains(script.getUserSettings().getEnchantedItem());
                            }
                        }.sleep();
                    }
                } else {
                    if(!script.getInventory().contains(script.getUserSettings().getItemToEnchant())) {
                        if(script.getBank().contains(script.getUserSettings().getItemToEnchant())) {
                            if(script.getBank().withdrawAll(script.getUserSettings().getItemToEnchant())) {
                                new ConditionalSleep(5000) {
                                    @Override
                                    public boolean condition() throws InterruptedException {
                                        return script.getInventory().contains(script.getUserSettings().getItemToEnchant());
                                    }
                                }.sleep();
                            }
                        } else {
                            script.log("Ran out of items to enchant");
                            script.stop();
                        }
                    }
                }
            } else {
                if(script.getBank().open()) {
                    new ConditionalSleep(5000) {
                        @Override
                        public boolean condition() throws InterruptedException {
                            return script.getBank().isOpen();
                        }
                    }.sleep();
                }
            }
        }
    }

    @Override
    public Priority priority() {
        return Priority.LOW;
    }

    @Override
    public String getName() {
        return "Banking";
    }
}
