import java.util.ArrayList;
import java.util.Calendar;
import static java.lang.Math.pow;

public class Singleton {
    
    private static ArrayList<Coupon> allCoupons;
    private static ArrayList<Product> allProducts;
    private static ArrayList<Request> allRequest;
    private static ArrayList<Sale> allSales;
    private static ArrayList<User>allUsers;
    private static ArrayList<Manager> allManagers;
    private static ArrayList<Buyer> allBuyers;
    private static ArrayList<Seller> allSellers;
    private static ArrayList<Category> allCategoriesAndSubcategories;
    private static ArrayList<Filter> allFilters;
    public static final String[] availableSorts = new String[3]{"Sort By Date", "Sort By Rating", "Sort By views"};
    private static String currentSortBeingUsed = "Sort By Views";
    private static ArrayList<Product> existingProducts; // products displayed in products page or offs page
    
    public Singleton() {
    
    }
    
    public void mainPage() {
    
    }
    
    public int generateRandomNumber (int numberOfDigits) {
        int min = (int) pow(10, numberOfDigits-1);
        int max = (int) (pow(10, numberOfDigits) - 1);
        
        int result = (int) (Math.random() * (max - min + 1) + min);
        
        return result;
    }
    
    public class User{
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;
        private boolean isLoggedIn = false;
    }
    public class Seller extends User
    public class Buyer extends User
    public class Manager extends User
    public class Request
    public class Order {
        private String orderId;
        private DateAndTime dateAndTime;
        private ArrayList<Product> products;
        private int numOfProducts = 0;
        private double offSaleAmount, offCouponAmount, totalOffAmount = offSaleAmount + offCouponAmount;
        double totalPrice;
        
        public Order () {
        
        }
    }
    public class Log
    public class LogSell extends Log
    public class LogBuy extends Log
    public class Product
    public class Sale {
        private String offId;
        private ArrayList<Product> productList;
        private SaleState situation = SaleState.CREATION_INVESTIGATION;
        private DateAndTime startDateAndTime, endDateAndTime;
        private double percentage;
        
        public Sale(ArrayList<Product> productList, String endDateAndTime, double percentage) {
            this.offId = Integer.toString(generateRandomNumber(3));
            this.productList = productList;
            int startYear = Calendar.getInstance().get(Calendar.YEAR);
            int startMonth = Calendar.getInstance().get(Calendar.MONTH);
            int startDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int startHour = Calendar.getInstance().get(Calendar.HOUR);
            int startMinute = Calendar.getInstance().get(Calendar.MINUTE);
            int startSecond = Calendar.getInstance().get(Calendar.SECOND);
            this.startDateAndTime = new DateAndTime(startHour, startMinute, startSecond, startYear, startMonth, startDay);
            int endYear = Integer.parseInt(endDateAndTime.substring(0, 4));
            int endMonth = Integer.parseInt(endDateAndTime.substring(5, 7));
            int endDay = Integer.parseInt(endDateAndTime.substring(8, 10));
            int endHour = Integer.parseInt(endDateAndTime.substring(11, 13));
            int endMinute = Integer.parseInt(endDateAndTime.substring(14, 16));
            int endSecond = Integer.parseInt(endDateAndTime.substring(17,19));
            this.endDateAndTime = new DateAndTime(endHour, endMinute, endSecond, endYear, endMonth, endDay);
            this.percentage = percentage;
        }
    }
    public enum SaleState {
        CREATION_INVESTIGATION,
        EDITION_INVESTIGATION,
        ACCEPTED
    }
    public class Comment
    public class Category
    public class Rating {
        public Buyer buyer;
        public double ratingNumber;
        public Product product;
        
        public Rating (double ratingNumber, Product product) {
            this.ratingNumber = ratingNumber;
            this.product = product;
        }
    }
    public class Coupon
    public class Filter
    public class ShoppingCart {
        private ArrayList<Product> productsInCart;
        private int numberOfProducts = 0;
        private double offSaleAmount = 0, offCouponAmount = 0, totalOffAmount = 0
        private double totalPrice = 0
        private boolean hasEnoughCredit = true
        
        public ShoppingCart () { // constructor
        
        }
        
    }
    public class DateAndTime {
        public int hour;
        public int minute;
        public int second;
        public int year;
        public int month;
        public int day;
    
        public DateAndTime (int hour, int minute, int second, int year, int month, int day) {
            if (isValid()) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
                this.year = year;
                this.month = month;
                this.day = day;
            } else System.out.println("invalid date");
        }
        
        public boolean isLeap () {
            int year = this.year;
            if (year%4==0 && year%100==0 && year%400==0)
                return true;
            else
                return false;
        }
        
        public boolean isValid () {
            if (hour >= 24 || hour < 0 || minute >= 60 || minute < 0 || second >= 60 || second < 0 || month > 12 || month <= 0 || day <= 0)
                return false;
            else
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (day > 31) return false;
                        else return true;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (day > 30) return false;
                        else return true
                    case 2:
                        if ((this.isLeap() && day>29) || (!this.isLeap() && day>28)) return false;
                        else return true;
                }
        }
    }
    
}























