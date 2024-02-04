package club.someoneice.www.bakery.init;

import club.someoneice.www.bakery.item.ItemFoodHelper;

public final class ItemInit {
    private ItemInit() {}

    public static final ItemFoodHelper.Builder HARD_BREAD = new ItemFoodHelper.Builder(2, 0.1f).setItemUseTick(48).addText("hard_bread.baking_time.info");
    public static final ItemFoodHelper.Builder LYE_BREAD = new ItemFoodHelper.Builder(5, 0.8f).addText("lye_bread.baking_time.info");
    public static final ItemFoodHelper.Builder BUM = new ItemFoodHelper.Builder(6, 0.8f).addText("bum.baking_time.info");
    public static final ItemFoodHelper.Builder BAKE_CHEESE = new ItemFoodHelper.Builder(4, 0.8f).setItemUseTick(16).addText("bake_cheese.baking_time.info");
    public static final ItemFoodHelper.Builder SUGAR_COOKIE = new ItemFoodHelper.Builder(1, 0.1f).setItemUseTick(16).addText("sugar_cookie.baking_time.info");
    public static final ItemFoodHelper.Builder SOFT_CAKE = new ItemFoodHelper.Builder(7, 0.8f).addText("soft_cake.baking_time.info");
    public static final ItemFoodHelper.Builder WHEAT_CRACKER = new ItemFoodHelper.Builder(3, 0.8f).setItemUseTick(16).addText("wheat_cracker.baking_time.info");
    public static final ItemFoodHelper.Builder BAGEL = new ItemFoodHelper.Builder(5, 0.9f).addText("bagel.baking_time.info");
    public static final ItemFoodHelper.Builder EGG_TART = new ItemFoodHelper.Builder(3, 0.1f).addText("egg_tart.baking_time.info");
    public static final ItemFoodHelper.Builder EGG_PUDDING = new ItemFoodHelper.Builder(5, 0.3f).addText("egg_pudding.baking_time.info");
    public static final ItemFoodHelper.Builder DONUT = new ItemFoodHelper.Builder(8, 1.4f).addText("donut.baking_time.info");

    public static final ItemFoodHelper.Builder SWISS_ROLL = new ItemFoodHelper.Builder(14, 1.7f).addText("swiss_roll.baking_time.info");
    public static final ItemFoodHelper.Builder SMALL_CAKE = new ItemFoodHelper.Builder(3, 0.1f).setItemUseTick(8).addText("small_cake.baking_time.info");
    public static final ItemFoodHelper.Builder BURGER = new ItemFoodHelper.Builder(15, 2.0f).addText("burger.baking_time.info");
    public static final ItemFoodHelper.Builder SANDWICH = new ItemFoodHelper.Builder(12, 1.7f).addText("sandwich.baking_time.info");
    public static final ItemFoodHelper.Builder HOTDOG = new ItemFoodHelper.Builder(14, 2.0f).addText("hotdog.baking_time.info");

    public static void init() {}
}
