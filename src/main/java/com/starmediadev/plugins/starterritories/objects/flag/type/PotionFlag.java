package com.starmediadev.plugins.starterritories.objects.flag.type;

import com.starmediadev.plugins.starterritories.objects.flag.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.*;

public class PotionFlag extends TypeFlag<PotionEffectType> {
    
    public PotionFlag(String name, boolean requiresPlayer, FlagValue defaultTypeValue) {
        super(name, requiresPlayer, defaultTypeValue);
    }
    
    @Override
    public PotionEffectType convertInput(String input) {
        return PotionEffectType.getByName(input);
    }
    
    @Override
    public boolean isValidType(Object object) {
        return object instanceof PotionEffectType;
    }
    
    @Override
    protected FlagValue checkRestricted(Player player, Object object) {
        if (this.value == FlagValue.RESTRICTED) {
            if (object instanceof PotionEffectType potionType) {
                return types.getOrDefault(potionType, this.defaultTypeValue);
            }
        }
        
        return this.value;
    }
}
