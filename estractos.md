En  ChromeManager

    private WebDriver setUp() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        driver = new GifWebDriver(new ChromeDriver(chromeOptions));







        return driver;
    }

    cambiar el         driver = new GifWebDriver(new ChromeDriver(chromeOptions));
por 

driver = new ChromeDriver(chromeOptions);

y en hooks cambiar añadir 
startRecord("test"); (en SetUP)
stopRecord(); en TearDawmn
