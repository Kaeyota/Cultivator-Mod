## Introduction

This is a cultivator mod for minecraft. As you gain levels, you become more powerful.

## Design rational:

Everything is based on the experience bar.
The goal is to enhance vanilla gameplay and minimally interfer.
We want it to fit very naturally and therefore avoid a database if possible.

## Core Features

* Tribulation
    * Lightning
    * Fire
    * Wither, etc
    * Lvl 10 is sth like "As you absorb experience orbs, you start to feel like there may be some deeper connection to the world gained"
    * Hello messages at 10, 20, 28,29,30, etc
    * Maybe kill half shanks @ 20
    * _Trial_, not strictly lethal.
    * Ie - @ 70 lightning to bring down to half a heart if in full iron
* Enhancement
    * XP is your cultivation charge - things cost XP to do
        * DR comes from XP, hitting harder shouldn't
    * Hit harder
    * Damage reduction? - Maybe add armor toughness value?
    * Fist pickaxe - costs xp; makes pickaxe still valuable (also enchants)

Sub points:

* If they spend levels, they don't have to redo tribulation, if they die they do have to
* At higher levels, reduce costs to enchant/anvil to est level cost

### Gateway levels

What kind of curve? Exponential?

- Lvl 30 = 1395
- Lvl 40 = 2920; about twice, uncommon but not hard to reach
- Lvl 50 = 5345 - not twice 40, but about 40 + 30 xp
- Lvl 60 = 8670 - more than 50 + 40
- Lvl 70 = 12895
- Lvl 80 = 18020
- Lvl 90 = 24045
- Lvl 100 = 30970

Maybe simple hello messages at level 10 and 20.

So the 10s seem like pretty decent breakpoints
- large tribulations as the 10s
- Small gains to damage/reduction by percentile chance - add 5% chance per interim level to add 1 to the effect

Names:
* level 10 = sapling
* level 20 = dirt
* level 30 = gravel
* level 40 = flint
* level 50 = stone
* level 60 = gold
* level 70 = iron
* level 80 = diamond
* level 90 = obsidian
* level 100 - start introducing real cultivation terms? Actively try to kill the player

Boosts:
* Damage - +1 per 10 levels; +5% +1 per level between
* Add armor toughness (equivalent) +1 per 10 level; +5% +1 per level between
* Iron lets mine iron w/fists
* Stone lets mine cobble/coal w/fists

## Ideas:

- At higher levels, player gets a greater xp gain
- Potions with ingredient order mattering
- Magical ingredients based on flowers
- Monsters get more powerful based on distance from (0,0), but are also worth more xp
- Different trials as you level ex. lightning, wither, posion, fall damage, lava/fire, monsters etc.
  - You get rewards apropriate to the trial you past.
- You do more damage as you level up, more hit points
- Armor and weapons can be upgraded with xp
- Flying swords. Flight with flying swords and decreases durability. Also a long range attack option.
- Implement meditation for gathering xp. Maybe at a higher level. Some kind of AFK prevention.
  - Possible holding special books to cultivate/meditate.
  - Cultivation of glutton. Eat diamonds to gain xp.
- Rare cultivation books in dungeon loot. Has additional information on level up trials.
- Spirit stones. Possibly based on emeralds.
  - When emeralds are mined, have a posibility of creating a spirit stone.
  - Special spirit stone veins.
- Formations based on spirit stones.
- Talismans. A piece of paper with a special name.
- Pill refining, using furance, with special dyes, and conduit as the base
- Cultivation technique that uses xp. Possibly by holding the book with the technique.
  - Concern about what will happen if xp drops and retaking trials.
  - Perhaps track what level the player has reached so they don't retake trials.
  - Make echantments at higher levels cost less, or have greater effects.
    - Possibly make it cost 30 levels worth of xp.
- xp for reading books based on page turn speed. Flip through slowly.
- Talisman to prevent level up, which uses durability. Or a one time use.
- Tailsman can be nametag or paper
- As you level up, your fists become equivilant to tools.
  - Fists being enchanted by slips of paper in your inventory. Called technique scrolls. Maybe dungeon loot only.
- Areas of high and low spiritual energy based on world gen. Mountains are naturally higher in energy.
  - Affinity based on area and cultivation technique.
  - Can have cumulative effect with spiritual formations.
- Dungeon chests will have a chance of adding a cultiavtion technique.
- Would be nice to have it able to work in bukkit and forge.
- After passing a certain level, have the ability to live and keep all xp after dying
- Immunities/Resistances - resistances before immunities
    - Poison
    - Wither
    - Must be gated by tribulations involving them; makes passing them again easier
    - Ex - explosion trial - build small obsidian box, spawn primed TNT/creepers on hair trigger next to them in it
- Might toggle strong hit mode w/xp cost w/crouch+crouch+jump trigger, turn off w/crouch+crouch+crouch or sth
- Maybe grand realms every level 100
- Warning messages at level ups near 100 - this mod will try to _kill you_
- Also introduce bottlenecks maybe - xp gain ignored w/probability; maybe easier to break through the more gained at a time or sth
- Brew pot of xp maybe
- Flight; level 100+
- Special cultivation technique - eat food for xp
