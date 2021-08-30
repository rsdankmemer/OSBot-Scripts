package autoenchanter.src.data;

import org.osbot.rs07.api.ui.MagicSpell;
import org.osbot.rs07.api.ui.Spells;

import static autoenchanter.src.data.EnchantedItem.*;

public enum UnenchantedItem {
    OPAL_RING(RING_OF_PURSUIT, Spells.NormalSpells.LVL_1_ENCHANT),
    OPAL_NECKLACE(DODGY_NECKLACE, Spells.NormalSpells.LVL_1_ENCHANT),
    OPAL_BRACELET(EXPEDITIOUS_BRACELET, Spells.NormalSpells.LVL_1_ENCHANT),
    OPAL_AMULET(AMULET_OF_BOUNTY, Spells.NormalSpells.LVL_1_ENCHANT),
    JADE_RING(RING_OF_RETURNING, Spells.NormalSpells.LVL_2_ENCHANT),
    JADE_NECKLACE(NECKLACE_OF_PASSAGE, Spells.NormalSpells.LVL_2_ENCHANT),
    JADE_BRACELET(FLAMTAER_BRACELET, Spells.NormalSpells.LVL_2_ENCHANT),
    JADE_AMULET(AMULET_OF_CHEMISTRY, Spells.NormalSpells.LVL_2_ENCHANT),
    SAPPHIRE_RING(RING_OF_RECOIL, Spells.NormalSpells.LVL_1_ENCHANT),
    SAPPHIRE_NECKLACE(GAMES_NECKLACE, Spells.NormalSpells.LVL_1_ENCHANT),
    SAPPHIRE_BRACELET(BRACELET_OF_CLAY, Spells.NormalSpells.LVL_1_ENCHANT),
    SAPPHIRE_AMULET(AMULET_OF_MAGIC, Spells.NormalSpells.LVL_1_ENCHANT),
    EMERALD_RING(RING_OF_DUELING, Spells.NormalSpells.LVL_2_ENCHANT),
    EMERALD_NECKLACE(BINDING_NECKLACE, Spells.NormalSpells.LVL_2_ENCHANT),
    EMERALD_BRACELET(CASTLE_WARS_BRACELET, Spells.NormalSpells.LVL_2_ENCHANT),
    EMERALD_AMULET(AMULET_OF_DEFENCE, Spells.NormalSpells.LVL_2_ENCHANT),
    TOPAZ_NECKLACE(NECKLACE_OF_FAITH, Spells.NormalSpells.LVL_3_ENCHANT),
    TOPAZ_BRACELET(BRACELET_OF_SLAUGHTER, Spells.NormalSpells.LVL_3_ENCHANT),
    TOPAZ_AMULET(BURNING_AMULET, Spells.NormalSpells.LVL_3_ENCHANT),
    RUBY_RING(RING_OF_FORGING, Spells.NormalSpells.LVL_3_ENCHANT),
    RUBY_NECKLACE(DIGSITE_PENDANT, Spells.NormalSpells.LVL_3_ENCHANT),
    RUBY_BRACELET(INOCULATION_BRACELET, Spells.NormalSpells.LVL_3_ENCHANT),
    RUBY_AMULET(AMULET_OF_STRENGTH, Spells.NormalSpells.LVL_3_ENCHANT),
    DIAMOND_RING(RING_OF_LIFE, Spells.NormalSpells.LVL_4_ENCHANT),
    DIAMOND_NECKLACE(PHOENIX_NECKLACE, Spells.NormalSpells.LVL_4_ENCHANT),
    DIAMOND_BRACELET(ABYSSAL_BRACELET, Spells.NormalSpells.LVL_4_ENCHANT),
    DIAMOND_AMULET(AMULET_OF_POWER, Spells.NormalSpells.LVL_4_ENCHANT),
    DRAGONSTONE_RING(RING_OF_WEALTH, Spells.NormalSpells.LVL_5_ENCHANT),
    DRAGONSTONE_NECKLACE(SKILLS_NECKLACE, Spells.NormalSpells.LVL_5_ENCHANT),
    DRAGONSTONE_BRACELET(COMBAT_BRACELET, Spells.NormalSpells.LVL_5_ENCHANT),
    DRAGONSTONE_AMULET(AMULET_OF_GLORY, Spells.NormalSpells.LVL_5_ENCHANT),
    ONYX_RING(RING_OF_STONE, Spells.NormalSpells.LVL_6_ENCHANT),
    ONYX_NECKLACE(BERSERKER_NECKLACE, Spells.NormalSpells.LVL_6_ENCHANT),
    ONYX_BRACELET(REGENT_BRACELET, Spells.NormalSpells.LVL_6_ENCHANT),
    ONYX_AMULET(AMULET_OF_FURY, Spells.NormalSpells.LVL_6_ENCHANT),
    ZENYTE_RING(RING_OF_SUFFERING, Spells.NormalSpells.LVL_7_ENCHANT),
    ZENYTE_NECKLACE(NECKLACE_OF_ANGUISH, Spells.NormalSpells.LVL_7_ENCHANT),
    ZENYTE_BRACELET(TORMENTED_BRACELET, Spells.NormalSpells.LVL_7_ENCHANT),
    ZENYTE_AMULET(AMULET_OF_TORTURE, Spells.NormalSpells.LVL_7_ENCHANT);

    private EnchantedItem enchantedItem;
    private MagicSpell enchantSpell;

    UnenchantedItem(EnchantedItem enchantedItem, MagicSpell enchantSpell) {
        this.enchantedItem = enchantedItem;
        this.enchantSpell = enchantSpell;
    }

    public EnchantedItem getEnchantedItem() {
        return enchantedItem;
    }

    public MagicSpell getEnchantSpell() {
        return enchantSpell;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.charAt(0) + sb.substring(1).toLowerCase().replace("_", " ");
    }
}
