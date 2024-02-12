package club.someoneice.www.bakery;

import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public final class ItemInit {
    private ItemInit() {}

    public static final ItemFoodHelper.Builder HARD_BREAD = new ItemFoodHelper.Builder(2, 0.1f).setItemUseTick(48).addText("hard_bread.golden_psalms.info");
    public static final ItemFoodHelper.Builder LYE_BREAD = new ItemFoodHelper.Builder(5, 0.8f).addText("lye_bread.golden_psalms.info");
    public static final ItemFoodHelper.Builder BUM = new ItemFoodHelper.Builder(6, 0.8f).addText("bun.golden_psalms.info");
    public static final ItemFoodHelper.Builder BAKE_CHEESE = new ItemFoodHelper.Builder(4, 0.8f).setItemUseTick(16).addText("bake_cheese.golden_psalms.info");
    public static final ItemFoodHelper.Builder SUGAR_COOKIE = new ItemFoodHelper.Builder(1, 0.1f).setItemUseTick(16).addText("sugar_cookie.golden_psalms.info");
    public static final ItemFoodHelper.Builder SOFT_CAKE = new ItemFoodHelper.Builder(7, 0.8f).addText("soft_cake.golden_psalms.info");
    public static final ItemFoodHelper.Builder WHEAT_CRACKER = new ItemFoodHelper.Builder(3, 0.8f).setItemUseTick(16).addText("wheat_cracker.golden_psalms.info");
    public static final ItemFoodHelper.Builder BAGEL = new ItemFoodHelper.Builder(5, 0.9f).addText("bagel.golden_psalms.info");
    public static final ItemFoodHelper.Builder EGG_TART = new ItemFoodHelper.Builder(3, 0.1f).addText("egg_tart.golden_psalms.info");
    public static final ItemFoodHelper.Builder EGG_PUDDING = new ItemFoodHelper.Builder(5, 0.3f).addText("egg_pudding.golden_psalms.info");
    public static final ItemFoodHelper.Builder DONUT = new ItemFoodHelper.Builder(8, 1.4f).addText("donut.golden_psalms.info");

    public static final ItemFoodHelper.Builder SWISS_ROLL = new ItemFoodHelper.Builder(14, 1.7f).addText("swiss_roll.golden_psalms.info");
    public static final ItemFoodHelper.Builder SMALL_CAKE = new ItemFoodHelper.Builder(3, 0.1f).setItemUseTick(8).addText("small_cake.golden_psalms.info");
    public static final ItemFoodHelper.Builder BURGER = new ItemFoodHelper.Builder(18, 2.0f).addText("burger.golden_psalms.info");
    public static final ItemFoodHelper.Builder SANDWICH = new ItemFoodHelper.Builder(14, 1.7f).addText("sandwich.golden_psalms.info");
    public static final ItemFoodHelper.Builder HOTDOG = new ItemFoodHelper.Builder(15, 2.0f).addText("hotdog.golden_psalms.info");

    public static final ItemFoodHelper.Builder BEER = new ItemFoodHelper.Builder(5, 0.1f).addText("beer.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));
    public static final ItemFoodHelper.Builder SAUCE_WING = new ItemFoodHelper.Builder(5, 0.1f).addText("sauce_wine.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));
    public static final ItemFoodHelper.Builder MOONLIGHT = new ItemFoodHelper.Builder(5, 0.1f).addText("moonlight.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));
    public static final ItemFoodHelper.Builder WHEAT_MILK_TEA = new ItemFoodHelper.Builder(5, 0.1f).addText("wheat_milk_tea.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));

    public static final ItemFoodHelper.Builder RICE = new ItemFoodHelper.Builder(8, 1.0f).addText("rice.golden_psalms.info").setItemReturn(new ItemStack(Items.bowl));
    public static final ItemFoodHelper.Builder RICE_WINE = new ItemFoodHelper.Builder(5, 1.0f).addText("rice_wine.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));
    public static final ItemFoodHelper.Builder RICE_BALL = new ItemFoodHelper.Builder(5, 0.7f).addText("rice_ball.golden_psalms.info").setItemUseTick(24);
    public static final ItemFoodHelper.Builder RICE_MILK_SHAKE = new ItemFoodHelper.Builder(5, 0.7f).addText("rice_milk_shake.golden_psalms.info").setCanAlwaysEat().setItemUseAction(EnumAction.drink).setItemReturn(new ItemStack(Items.glass_bottle));

    public static void init() {}
}
