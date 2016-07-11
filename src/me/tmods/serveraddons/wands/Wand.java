package me.tmods.serveraddons.wands;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

import me.tmods.serverutils.Methods;

public enum Wand {
	Explosion(Material.BLAZE_ROD,"Explosion Wand",Particle.FLAME,Sound.ENTITY_FIREWORK_LAUNCH,"Explosion"),
	Heal(Material.STICK,"Healing Wand",Particle.HEART,Sound.ENTITY_PLAYER_BREATH,"Heal"),
	Protection(Material.IRON_INGOT,"Protection Wand",Particle.CRIT,Sound.ENTITY_IRONGOLEM_STEP,"Protection"),
	Poison(Material.SPIDER_EYE,"Poison Wand",Particle.WATER_BUBBLE,Sound.BLOCK_GLASS_BREAK,"Poison"),
	Boost(Material.STICK,"Booster Wand",Particle.FIREWORKS_SPARK,Sound.ENTITY_ENDERDRAGON_FLAP,"Boost"),
	Damage(Material.WOOD_HOE,"Damage Wand",Particle.DRIP_LAVA,Sound.ENTITY_SPIDER_DEATH,"Damage"),
	Battle(Material.STICK,"Battle Wand",Particle.DRIP_WATER,Sound.ENTITY_ARROW_HIT,"Battle"),
	Regen(Material.GOLD_AXE,"Regeneration Wand",Particle.BLOCK_CRACK,Sound.BLOCK_STONE_STEP,"Regen"),
	Speed(Material.FLINT_AND_STEEL,"Speed Wand",Particle.FLAME,Sound.ENTITY_LIGHTNING_THUNDER,"Speed"),
	Invisible(Material.GLASS_BOTTLE,"Invisibility Wand",Particle.WATER_BUBBLE,Sound.AMBIENT_CAVE,"Invisible"),
	NightVision(Material.THIN_GLASS,"Night Vision Wand",Particle.BLOCK_DUST,Sound.BLOCK_CLOTH_STEP,"Bright"),
	Jumping(Material.GLASS_BOTTLE,"Jumping Wand",Particle.CRIT,Sound.ENTITY_PLAYER_ATTACK_STRONG,"Jump"),
	Slow(Material.SOUL_SAND,"Slowness Wand",Particle.SLIME,Sound.ENTITY_SLIME_ATTACK,"Slow"),
	WaterBreath(Material.GLASS,"Breathing Wand",Particle.WATER_BUBBLE,Sound.ENTITY_PLAYER_BREATH,"WaterBreath"),
	FireResistance(Material.LAVA_BUCKET,"FireResistance Wand",Particle.FLAME,Sound.BLOCK_FIRE_AMBIENT,"AntiFire"),
	Strength(Material.GOLD_SWORD,"Strength Wand",Particle.CRIT_MAGIC,Sound.ENTITY_PLAYER_ATTACK_STRONG,"Strong"),
	Weakness(Material.WOOL,"Weakness Wand",Particle.CLOUD,Sound.BLOCK_CLOTH_STEP,"Weak"),
	Luck(Material.EXP_BOTTLE,"Luck Wand",Particle.ENCHANTMENT_TABLE,Sound.ENTITY_BLAZE_HURT,"Luck"),
	UnLuck(Material.EXP_BOTTLE,"UnLuck Wand",Particle.ENCHANTMENT_TABLE,Sound.ENTITY_BLAZE_DEATH,"UnLuck"),
	Haste(Material.GOLD_PICKAXE,"Haste Wand",Particle.CRIT,Sound.BLOCK_STONE_STEP,"Haste"),
	MiningFatigue(Material.WOOD_AXE,"Mining Fatigue Wand",Particle.BLOCK_CRACK,Sound.BLOCK_STONE_STEP,"SlowMine"),
	Nausea(Material.POISONOUS_POTATO,"Nausea Wand",Particle.SLIME,Sound.ENTITY_SLIME_ATTACK,"Nausea"),
	Blindness(Material.OBSIDIAN,"Blindness Wand",Particle.SMOKE_LARGE,Sound.AMBIENT_CAVE,"Blind"),
	Wither(Material.BLAZE_POWDER,"Wither Wand",Particle.SPELL_WITCH,Sound.ENTITY_WITHER_SHOOT,"Wither"),
	HealthBoost(Material.INK_SACK,"Health Boost Wand",Particle.HEART,Sound.ENTITY_VILLAGER_DEATH,"AddHealth"),
	Absorbtion(Material.GOLDEN_APPLE,"Absorbtion Wand",Particle.PORTAL,Sound.BLOCK_FIRE_AMBIENT,"Absorb"),
	Saturation(Material.COOKED_BEEF,"Saturation Wand",Particle.ITEM_TAKE,Sound.ENTITY_GENERIC_EAT,"Food"),
	Glowing(Material.GLOWSTONE_DUST,"Glowing Wand",Particle.REDSTONE,Sound.BLOCK_FIRE_EXTINGUISH,"Glow"),
	Levitation(Material.GOLDEN_CARROT,"Levitation Wand",Particle.SPELL_INSTANT,Sound.ENTITY_FIREWORK_BLAST,"Fly"),
	Hunger(Material.ROTTEN_FLESH,"Hunger Wand",Particle.CRIT,Sound.ENTITY_GENERIC_EAT,"Hunger"),
	Clear(Material.MILK_BUCKET,"Clearing Wand",Particle.WATER_BUBBLE,Sound.ENTITY_GENERIC_DRINK,"Clear");
	private Material material;
	private String itemName;
	private Particle particle;
	private Sound sound;
	private String name;
	private Wand(Material material,String itemName,Particle particle,Sound sound,String name) {
		this.material = material;
		this.itemName = itemName;
		this.particle = particle;
		this.sound = sound;
		this.name = name;
	}
	
	public String getItemName() {
		return this.itemName;
	}	
	public Material getMaterial() {
		return this.material;
	}
	public String getName() {
		return this.name;
	}
	public Particle getParticle() {
		return this.particle;
	}
	public Sound getSound() {
		return this.sound;
	}
	
	public static Wand fromString(String s) {
		try {
		if (s == null || s == "") {
			return null;
		}
		if (s.equalsIgnoreCase(Explosion.getName()))
		{
			return Explosion;
		}
		if (s.equalsIgnoreCase(Heal.getName()))
		{
			return Heal;
		}
		if (s.equalsIgnoreCase(Protection.getName()))
		{
			return Protection;
		}
		if (s.equalsIgnoreCase(Poison.getName()))
		{
			return Poison;
		}
		if (s.equalsIgnoreCase(Boost.getName()))
		{
			return Boost;
		}
		if (s.equalsIgnoreCase(Damage.getName()))
		{
			return Damage;
		}
		if (s.equalsIgnoreCase(Battle.getName())) {
			return Battle;
		}
		if (s.equalsIgnoreCase(Regen.getName())) {
			return Regen;
		}
		if (s.equalsIgnoreCase(Invisible.getName())) {
			return Invisible;
		}
		if (s.equalsIgnoreCase(NightVision.getName())) {
			return NightVision;
		}
		if (s.equalsIgnoreCase(Jumping.getName())) {
			return Jumping;
		}
		if (s.equalsIgnoreCase(Slow.getName())) {
			return Slow;
		}
		if (s.equalsIgnoreCase(WaterBreath.getName())) {
			return WaterBreath;
		}
		if (s.equalsIgnoreCase(FireResistance.getName())) {
			return FireResistance;
		}
		if (s.equalsIgnoreCase(Strength.getName())) {
			return Strength;
		}
		if (s.equalsIgnoreCase(Weakness.getName())) {
			return Weakness;
		}
		if (s.equalsIgnoreCase(Luck.getName())) {
			return Luck;
		}
		if (s.equalsIgnoreCase(UnLuck.getName())) {
			return UnLuck;
		}
		if (s.equalsIgnoreCase(Haste.getName())) {
			return Haste;
		}
		if (s.equalsIgnoreCase(MiningFatigue.getName())) {
			return MiningFatigue;
		}
		if (s.equalsIgnoreCase(Speed.getName())) {
			return Speed;
		}
		if (s.equalsIgnoreCase(Nausea.getName())) {
			return Nausea;
		}
		if (s.equalsIgnoreCase(Blindness.getName())) {
			return Blindness;
		}
		if (s.equalsIgnoreCase(Wither.getName())) {
			return Wither;
		}
		if (s.equalsIgnoreCase(HealthBoost.getName())) {
			return HealthBoost;
		}
		if (s.equalsIgnoreCase(Absorbtion.getName())) {
			return Absorbtion;
		}
		if (s.equalsIgnoreCase(Saturation.getName())) {
			return Saturation;
		}
		if (s.equalsIgnoreCase(Glowing.getName())) {
			return Glowing;
		}
		if (s.equalsIgnoreCase(Levitation.getName())) {
			return Levitation;
		}
		if (s.equalsIgnoreCase(Hunger.getName())) {
			return Hunger;
		}
		if (s.equalsIgnoreCase(Clear.getName())) {
			return Clear;
		}
		} catch (Exception e) {
			Methods.log(e);
		}
		return null;
	}
	public static Wand fromStringItem(String s) {
		if (s == null || s == "") {
			return null;
		}
		try {
		if (s.equalsIgnoreCase(Explosion.getItemName()))
		{
			return Explosion;
		}
		if (s.equalsIgnoreCase(Heal.getItemName())) 
		{
			return Heal;
		}
		if (s.equalsIgnoreCase(Protection.getItemName())) 
		{
			return Protection;
		}
		if (s.equalsIgnoreCase(Poison.getItemName())) 
		{
			return Poison;
		}
		if (s.equalsIgnoreCase(Boost.getItemName())) 
		{
			return Boost;
		}
		if (s.equalsIgnoreCase(Damage.getItemName())) 
		{
			return Damage;
		}
		if (s.equalsIgnoreCase(Battle.getItemName())) {
			return Battle;
		}
		if (s.equalsIgnoreCase(Regen.getItemName())) {
			return Regen;
		}
		if (s.equalsIgnoreCase(Invisible.getItemName())) {
			return Invisible;
		}
		if (s.equalsIgnoreCase(NightVision.getItemName())) {
			return NightVision;
		}
		if (s.equalsIgnoreCase(Jumping.getItemName())) {
			return Jumping;
		}
		if (s.equalsIgnoreCase(Slow.getItemName())) {
			return Slow;
		}
		if (s.equalsIgnoreCase(WaterBreath.getItemName())) {
			return WaterBreath;
		}
		if (s.equalsIgnoreCase(FireResistance.getItemName())) {
			return FireResistance;
		}
		if (s.equalsIgnoreCase(Strength.getItemName())) {
			return Strength;
		}
		if (s.equalsIgnoreCase(Weakness.getItemName())) {
			return Weakness;
		}
		if (s.equalsIgnoreCase(Luck.getItemName())) {
			return Luck;
		}
		if (s.equalsIgnoreCase(UnLuck.getItemName())) {
			return UnLuck;
		}
		if (s.equalsIgnoreCase(Haste.getItemName())) {
			return Haste;
		}
		if (s.equalsIgnoreCase(MiningFatigue.getItemName())) {
			return MiningFatigue;
		}
		if (s.equalsIgnoreCase(Speed.getItemName())) {
			return Speed;
		}
		if (s.equalsIgnoreCase(Nausea.getItemName())) {
			return Nausea;
		}
		if (s.equalsIgnoreCase(Blindness.getItemName())) {
			return Blindness;
		}
		if (s.equalsIgnoreCase(Wither.getItemName())) {
			return Wither;
		}
		if (s.equalsIgnoreCase(HealthBoost.getItemName())) {
			return HealthBoost;
		}
		if (s.equalsIgnoreCase(Absorbtion.getItemName())) {
			return Absorbtion;
		}
		if (s.equalsIgnoreCase(Saturation.getItemName())) {
			return Saturation;
		}
		if (s.equalsIgnoreCase(Glowing.getItemName())) {
			return Glowing;
		}
		if (s.equalsIgnoreCase(Levitation.getItemName())) {
			return Levitation;
		}
		if (s.equalsIgnoreCase(Hunger.getItemName())) {
			return Hunger;
		}
		if (s.equalsIgnoreCase(Clear.getItemName())) {
			return Clear;
		}
		} catch (Exception e) {
			Methods.log(e);
		}
		return null;
	}
}
