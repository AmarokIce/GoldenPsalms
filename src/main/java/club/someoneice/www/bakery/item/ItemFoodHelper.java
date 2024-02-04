package club.someoneice.www.bakery.item;

import club.someoneice.www.bakery.BakingMain;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public final class ItemFoodHelper extends ItemFood {
    public static final String REGISTER_NAME = "item_food_base";
    public static final List<Builder> items = Lists.newArrayList();
    final IIcon[] icons;

    public ItemFoodHelper() {
        super(0, 0, false);
        this.setCreativeTab(BakingMain.BAKING_TAB);
        this.setHasSubtypes(true);

        icons = new IIcon[items.size()];
        GameRegistry.registerItem(this, REGISTER_NAME, BakingMain.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        for (int i = 0; i < icons.length; i ++)
            icons[i] = register.registerIcon(BakingMain.MODID + ":" + REGISTER_NAME + "_" + i);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return meta < icons.length ? icons[meta] : icons[0];
    }

    @Override
    public String getUnlocalizedName(ItemStack item) {
        return "item.moon_cake." + item.getItemDamage();
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        Builder item = items.get(stack.getItemDamage());
        return item.itemUseAction;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        Builder item = items.get(stack.getItemDamage());
        return item.useTick;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        Builder item = items.get(stack.getItemDamage());
        if (player.canEat(item.canAlwaysEat))
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        Builder item = items.get(stack.getItemDamage());
        return item.finishUsingItem(stack, world, player);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < items.size(); i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag) {
        Builder item = items.get(stack.getItemDamage());
        list.addAll(item.list);
    }

    public static final class Builder {
        final int hunger;
        final float saturation;
        boolean canAlwaysEat = false;
        EnumAction itemUseAction = EnumAction.eat;
        int useTick = 32;
        final List<String> list = Lists.newArrayList();

        public Builder(int hunger, float saturation) {
            this.hunger = hunger;
            this.saturation = saturation;

            this.build();
        }

        public Builder setCanAlwaysEat() {
            this.canAlwaysEat = true;
            return this;
        }

        public Builder setItemUseAction(EnumAction action) {
            this.itemUseAction = action;
            return this;
        }

        public Builder setItemUseTick(int tick) {
            this.useTick = tick;
            return this;
        }

        public Builder addText(String ... args) {
            if (args.length < 1) return this;
            for (String arg : args) {
                list.add(new ChatComponentTranslation(arg).getFormattedText());
            }
            return this;
        }

        public Builder build() {
            ItemFoodHelper.items.add(this);
            return this;
        }

        public ItemStack finishUsingItem(ItemStack item, World world, EntityPlayer player) {
            player.getFoodStats().addStats(this.hunger, this.saturation);
            world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            --item.stackSize;
            return item;
        }
    }
}
