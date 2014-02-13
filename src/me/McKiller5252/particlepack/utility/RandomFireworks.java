package me.McKiller5252.particlepack.utility;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
 
import java.util.ArrayList;
import java.util.Random;

public class RandomFireworks {
	 
private static RandomFireworks fireWorks = new RandomFireworks();
 
 
public static RandomFireworks getManager(){
return fireWorks;
}
 

ArrayList<Color> colors = new ArrayList<Color>();
ArrayList<FireworkEffect.Type> types = new ArrayList<FireworkEffect.Type>();
 

public void addColors(){

colors.add(Color.WHITE);
colors.add(Color.PURPLE);
colors.add(Color.RED);
colors.add(Color.GREEN);
colors.add(Color.AQUA);
colors.add(Color.BLUE);
colors.add(Color.FUCHSIA);
colors.add(Color.GRAY);
colors.add(Color.LIME);
colors.add(Color.MAROON);
colors.add(Color.YELLOW);
colors.add(Color.SILVER);
colors.add(Color.TEAL);
colors.add(Color.ORANGE);
colors.add(Color.OLIVE);
colors.add(Color.NAVY);
colors.add(Color.BLACK);

}
 

public void addTypes(){

types.add(FireworkEffect.Type.BURST);
types.add(FireworkEffect.Type.BALL);
types.add(FireworkEffect.Type.BALL_LARGE);
types.add(FireworkEffect.Type.CREEPER);
types.add(FireworkEffect.Type.STAR);

}
 

 
public FireworkEffect.Type getRandomType(){
int size = types.size();
Random ran = new Random();
FireworkEffect.Type theType = types.get(ran.nextInt(size));
 
return theType;
}
 

 
public Color getRandomColor(){
int size = colors.size();
Random ran = new Random();
Color color = colors.get(ran.nextInt(size));
 
return color;
}
 
public void launchRandomFirework(Location loc){
Firework fw = loc.getWorld().spawn(loc, Firework.class);
FireworkMeta fm = fw.getFireworkMeta();
fm.setPower(1);

fm.addEffects(FireworkEffect.builder().with(getRandomType()).withColor(getRandomColor()).build());

fw.setFireworkMeta(fm);
}
}
