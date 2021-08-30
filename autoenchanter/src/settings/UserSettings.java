package autoenchanter.src.settings;

import org.osbot.rs07.api.ui.MagicSpell;

public class UserSettings {

    private String itemToEnchant;
    private String enchantedItem;
    private MagicSpell spell;

    public String getItemToEnchant() {
        return itemToEnchant;
    }

    public String getEnchantedItem() {
        return enchantedItem;
    }

    public MagicSpell getSpell() {
        return spell;
    }

    public void setItemToEnchant(String itemToEnchant) {
        this.itemToEnchant = itemToEnchant;
    }

    public void setEnchantedItem(String enchantedItem) {
        this.enchantedItem = enchantedItem;
    }

    public void setSpell(MagicSpell spell) {
        this.spell = spell;
    }
}
