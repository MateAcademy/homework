package homework;
//
import org.junit.*;
//
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
//
//import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
//
//

public class FruiteShopUnitTest {
//    private FruitShop fruitShop;
//    private static Fruit apple;
//    private static Fruit pear;
//    private static Fruit strawberry;
//    private static Fruit orange;
//
//
//
//    @BeforeClass
//    public static void beforeClass(){
//
//        apple =new Fruit(FruitType.APPLE, 19, LocalDate.of(2019,Month.JANUARY,17), 89,null );
//        pear =new Fruit(FruitType.APPLE, 19, LocalDate.of(2019,Month.SEPTEMBER,17), 89,null );
//        strawberry =new Fruit(FruitType.APPLE, 19, LocalDate.of(2019,Month.JANUARY,17), 89,null );
//        orange =new Fruit(FruitType.APPLE, 19, LocalDate.of(2019,Month.JANUARY,17), 89,null );
//         }
//
//    @Before
//    public void beforeTest() {
//        System.out.println("beforeTest");
//
//List<Fruit> fruits =new ArrayList<>();
//        fruits.add(apple);
//        fruits.add(pear);
//        fruits.add(strawberry);
//        fruits.add(orange);
//
//        fruitShop = new FruitShop("asdasd",fruits);
//    }
//
//    @Test
//    public void firstTest() {
//        System.out.println("--First test");
//    }
//
//    @Test
//    public void testAllFresh() {
//        System.out.println("--Second test");
//        List<Fruit> expected = new ArrayList<>();
//        expected.add(apple);
//
//        List<Fruit> outFruite = fruitShop.allFresh(LocalDate.of(2019,Month.JANUARY,18));
//        assertEquals(expected,outFruite);
//
//
//
//    }
//
//    @After
//    public void afterTest() {
//        System.out.println("afterTest");
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        System.out.println("afterClass"); }
//}

private FruitShop fruitShop;
private  static Fruit  apple;
private  static Fruit  pear;
private  static Fruit  orange;
private  static Fruit  strawberry;

        @BeforeClass
        public static void beforeClass(){
        apple = new Fruit(FruitType.APPLE,30, LocalDate.of(2019,1,4),12, null);
        pear = new Fruit(FruitType.PEAR,325, LocalDate.of(2019,1,8),12, null);
        orange = new Fruit(FruitType.ORANGE,30, LocalDate.of(2019,3,12),12, null);
        strawberry = new Fruit(FruitType.STRAWBERRY,30, LocalDate.of(2019,4,11),12, null);
        }

        @AfterClass
        public static void afterClass(){
        System.out.println(" After ");
        }

        @Before
        public void setUp() throws Exception {
        System.out.println("before before class");
        List<Fruit> fruts = new ArrayList<>();
        fruts.add(apple);
        fruts.add(pear);
        fruts.add(orange);
        fruts.add(strawberry);
        fruitShop = new FruitShop("New FrutShop",fruts);
        }

        @After
        public void testDown() throws Exception {
        System.out.println("after after class");
        fruitShop = null;
        }

        @Test
        public void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019,1,20));
        assertEquals(expected,actual);
        System.out.println("All Fresh");
        }

        @Test
        public void testAllFreshNull(){
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2020,1,4));
        assertTrue(actual.size()==0);
        }

        @Test
        public void testAllFruitOfFruitType(){
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
//        expected.add(pear);
        assertEquals(expected, fruitShop.allFruitOfFruitType(FruitType.APPLE));
        System.out.println("AllFruitType");
        }

        @Test
        public void testAllFruitOfFruitType2() {
                List<Fruit> expected = new ArrayList<>();
                expected.add(strawberry);
                assertEquals(expected, fruitShop.allFruitOfFruitType(FruitType.STRAWBERRY));
        }

        @Test
        public void testCheckByExpireDate() {
        List<Fruit> expected = new ArrayList<>();
//      expected.add(apple);
        expected.add(pear);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        assertEquals(expected, actual);
        }

        @Test
        public void testCheckByExpireDate2() {
                List<Fruit> expected = new ArrayList<>();
                expected.add(apple);
                expected.add(pear);
                expected.add(orange);
                expected.add(strawberry);
//              expected.add(apple);
                List<Fruit> actual = fruitShop.checkByExpireDate(29);
                assertEquals(expected, actual);
        }

        @Test
        public void testAllFreshAndFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 1, 21));
        assertEquals(expected, actual);
        }

        @Test
        public void testAllFreshAndFruitType2() {
                List<Fruit> expected = new ArrayList<>();
                expected.add(pear);
//                expected.add(apple);
                List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2019, 1, 21));
                assertEquals(expected, actual);
        }

        @Test
        public void testReSetPricexRealization() {
        List<Fruit> expected = new ArrayList<>();
        List<Fruit> actual = fruitShop.reSetPricexRealization(50, 10, FruitType.PEAR);
        assertEquals(expected, actual);
        }

        @Test
        public void testReSetPricexRealization2() {
                List<Fruit> expected = new ArrayList<>();
                expected.add(new Fruit(FruitType.APPLE, 30, LocalDate.of(2019, 01, 04), 6, null));
                List<Fruit> actual = fruitShop.reSetPricexRealization(50, 17, FruitType.APPLE);
                assertEquals(expected, actual);
        }
}