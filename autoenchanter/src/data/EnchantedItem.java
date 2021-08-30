package autoenchanter.src.data;

public enum EnchantedItem {
    RING_OF_PURSUIT,
    DODGY_NECKLACE,
    EXPEDITIOUS_BRACELET,
    AMULET_OF_BOUNTY,
    RING_OF_RETURNING,
    NECKLACE_OF_PASSAGE,
    FLAMTAER_BRACELET,
    AMULET_OF_CHEMISTRY,
    RING_OF_RECOIL,
    GAMES_NECKLACE,
    BRACELET_OF_CLAY,
    AMULET_OF_MAGIC,
    RING_OF_DUELING,
    BINDING_NECKLACE,
    CASTLE_WARS_BRACELET,
    AMULET_OF_DEFENCE,
    NECKLACE_OF_FAITH,
    BRACELET_OF_SLAUGHTER,
    BURNING_AMULET,
    RING_OF_FORGING,
    DIGSITE_PENDANT,
    INOCULATION_BRACELET,
    AMULET_OF_STRENGTH,
    RING_OF_LIFE,
    PHOENIX_NECKLACE,
    ABYSSAL_BRACELET,
    AMULET_OF_POWER,
    RING_OF_WEALTH,
    SKILLS_NECKLACE,
    COMBAT_BRACELET,
    AMULET_OF_GLORY,
    RING_OF_STONE,
    BERSERKER_NECKLACE,
    REGENT_BRACELET,
    AMULET_OF_FURY,
    RING_OF_SUFFERING,
    NECKLACE_OF_ANGUISH,
    TORMENTED_BRACELET,
    AMULET_OF_TORTURE;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.charAt(0) + sb.substring(1).toLowerCase().replace("_", " ");
    }
}
