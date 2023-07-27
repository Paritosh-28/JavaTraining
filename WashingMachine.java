import java.util.Random;

class InsufficientWaterException extends Exception{
    public InsufficientWaterException(String message) {
        super(message);
    }
}

class InsufficientElectricityException extends Exception{
    public InsufficientElectricityException(String message) {
        super(message);
    }
}

class WaterOverflowException extends Exception{
	public WaterOverflowException(String message) {
		super(message);
	}
}

class WashingMachineMalfunctionException extends Exception{
	public WashingMachineMalfunctionException(String message) {
		super(message);
	}
}
class WashingMachineTest {

	public static void main(String[] args) {
		
		WashingPowder washPowder = new WashingPowder(100,"Nirma", "Front Load", true, 10.0f);
		System.out.println("Wash Powder : "+washPowder); //toString is invoked
		
		Water waterType1 = new Water("cold", 7, "18°C"); 
		System.out.println("Water Type 1 : "+waterType1);
		Water waterType2 = new Water("Hot", 12, "40°C"); 
		System.out.println("Water Type 2 : "+waterType2);
		Water waterType3 = new Water("Warm", 22, "27°C"); 
		System.out.println("Water Type 3: "+waterType3);
		
		Electricity electricityType1 = new Electricity("AC", 220.0f, 8, 15, "Mahavitaran");
		System.out.println("Electricity : "+electricityType1);
		Electricity electricityType2 = new Electricity("AC", 220.0f, 9, 9, "APL");
		System.out.println("Electricity : "+electricityType2);
		Electricity electricityType3 = new Electricity("AC", 220.0f, 7, 17, "Mahavitaran");
		System.out.println("Electricity : "+electricityType3);
		
		
		Cloth[] clothes = new Cloth[5];
		clothes[0] = new Cloth("Cotton", "Blue", 250.99f, "T-Shirt", false);
		clothes[1] = new Cloth("Polyester", "Red", 390.99f, "Dress", true);
		clothes[2] = new Cloth("Denim", "Black", 340.99f, "Jeans", false);
		clothes[3] = new Cloth("Silk", "Green", 190.99f, "Bath Towel", false);
		clothes[4] = new Cloth("Linen", "White", 290.99f, "Pants", true);
		
		int i=0; 
		for (Cloth cloth : clothes) {
			System.out.println("cloth" + ++i + " : "+   cloth);
        }
		
		System.out.println("================================================\n");
	
        WashingTub tub1 = new WashingTub(50, "Front Load");
        WashingTub tub2 = new WashingTub(60, "Top Load");
        WashingTub tub3 = new WashingTub(40, "Semi-Automatic");

        WashingMachine washingMachine1 = new WashingMachine(tub1, washPowder, waterType1, electricityType1, clothes);
        WashingMachine washingMachine2 = new WashingMachine(tub2, washPowder, waterType2, electricityType2, clothes);
        WashingMachine washingMachine3 = new WashingMachine(tub3, washPowder, waterType3, electricityType3, clothes);

        Thread thread1 = new Thread(washingMachine1);
        Thread thread2 = new Thread(washingMachine2);
        Thread thread3 = new Thread(washingMachine3);

        System.out.println("---Testing Washing Machines---");
        thread1.start();
        thread2.start();
        thread3.start();
        
        
		
//		WashingMachine washingMachine = new WashingMachine();
//		Laundry laundry = washingMachine.wash(washPowder, water, electricity, clothes);
//		System.out.println("Number of Clothes : " + laundry.getNumberOfCloths());
//		System.out.println("Time Required to wash clothes : " + laundry.getTimeRequired() + " mins");
//		System.out.println("Total Cost of Clothes : " + laundry.getTotalCost() + " Rs");
//		System.out.println("Water Used for washing clothes : " + laundry.getWaterUsed() + " L");
//		System.out.println("Electricity Used for washing clothes : " + laundry.getElectricityUsed() + " kWh");
//		System.out.println("Cost of Washing Powder: " + laundry.getCostOfWashingPowder() + " Rs");
	}
}


class WashingMachine extends Thread{ 
	private WashingTub washTub;
	private WashingPowder washPowder;
	private Water water;
	private Electricity electricity;
	private Cloth clothes[];
//	private Laundry laundry;
	
	
//	WashingTub washTub = new WashingTub(); //hasA
	public WashingMachine(WashingTub washTub, WashingPowder washPowder, Water water, Electricity electricity, Cloth[] clothes){
		super();
        this.washTub = washTub;
        this.washPowder = washPowder;
        this.water = water;
        this.electricity = electricity;
        this.clothes = clothes;
	}

	@Override
    public void run() {
		try {
			Laundry laundry = wash(washPowder, water, electricity, clothes);
			
		}
		catch (InsufficientWaterException e) {
//            e.printStackTrace();
			System.out.println(this.washTub.getType() + "  " + e.getMessage());
        }
		catch(InsufficientElectricityException e) {
//			e.printStackTrace();
			System.out.println(this.washTub.getType() + "  " + e.getMessage());
		}
		catch(WaterOverflowException e) {
//			e.printStackTrace();
			System.out.println(this.washTub.getType() + "  " + e.getMessage());
		}
		catch(ThermostatFailureException e) {
//			e.printStackTrace();
			System.out.println(this.washTub.getType() + "  " + e.getMessage());
		}
		catch(WashingMachineMalfunctionException e) {
//			e.printStackTrace();
			System.out.println(this.washTub.getType() + "  " + e.getMessage());
		}
		
	}	
		Laundry wash(WashingPowder washPowder, Water water, Electricity electricity, Cloth clothes[]) throws InsufficientWaterException, InsufficientElectricityException, WaterOverflowException, WashingMachineMalfunctionException {
			
			Laundry laundry = new Laundry();
			// setting all values
			laundry.setNumberOfCloths(clothes.length);
			float timeRequired = 60.00f;
			laundry.setTimeRequired(timeRequired);
			 float totalCost = 0.0f;
		        for (Cloth cloth : clothes) {
		            totalCost += cloth.getCost();
		        }
			laundry.setTotalCost(totalCost);
			
			if((float)water.getQuantity() < 9) {
				throw new InsufficientWaterException("Insufficient water to wash clothes.");
			}
			
			laundry.setWaterUsed((float)water.getQuantity());
			//Electricity Used (in kWh) = Power (in kilowatts) × Time (in hours)
			
			int requiredElectricityUnits = 10;
		    if (electricity.getUnitUsed() < requiredElectricityUnits) {
		        throw new InsufficientElectricityException("Insufficient electricity. Cannot wash clothes.");
		    }
			float electricityUsed = electricity.getUnitUsed() * (timeRequired / 60.0f);
			laundry.setElectricityUsed(electricityUsed);
			laundry.setCostOfWashingPowder(washPowder.getPrice() * ((float)water.getQuantity() + electricityUsed));
			
			try {
	            System.out.println(this.washTub.getType()+ "  Starting the washing machine.");
	            Thread.sleep(2000);

	            // Simulating washing process
	            System.out.println(this.washTub.getType() + "  Washing clothes...");
	            Thread.sleep(3000);
	            
	         // Check if water overflows during rinsing
	            if (new Random().nextBoolean()) {
	                throw new WaterOverflowException("Water overflow during rinsing.");
	            }
	         // Simulating rinsing process
	            System.out.println(this.washTub.getType() + "  Rinsing clothes...");
	            Thread.sleep(2000);

	            // // Simulate thermostat failure
	            // String numericPart = water.getTemperature().replaceAll("[^0-9]", "");
	            // int temperature = Integer.parseInt(numericPart);// Convert the extracted string to an integer
	            // if (temperature > 30) {
	            //     throw new ThermostatFailureException("Thermostat failure. Water temperature too high.");
	            // }
	            
	            // Simulating spinning process
	            System.out.println(this.washTub.getType() + "  Spinning...");
	            Thread.sleep(1500);
	            // Simulating final steps
	            System.out.println(this.washTub.getType() + "  Finishing up...");
	            Thread.sleep(1000);

	            System.out.println(this.washTub.getType() + "  Washing complete.");
			}catch (InterruptedException e) {
	            throw new WashingMachineMalfunctionException("Washing machine malfunctioned.");
	        }
	            
			
//			Laundry laundry = new Laundry(cloth.length, timeRequired, totalCost, waterUsed, electricityUsed, costOfWashingPowder);
			return laundry;
		}
}



class Laundry {
	private int numberOfCloths; //cloth.length
	private float timeRequired;
	private float totalCost ;// cloth.length * price per cloth
	private float waterUsed;
	private float electricityUsed;
	private float costOfWashingPowder; //
	
	public Laundry() {
		
	}
	public Laundry(int numberOfCloths, float timeRequired, float totalCost, float waterUsed, float electricityUsed,
			float costOfWashingPowder) {
		super();
		this.numberOfCloths = numberOfCloths;
		this.timeRequired = timeRequired;
		this.totalCost = totalCost;
		this.waterUsed = waterUsed;
		this.electricityUsed = electricityUsed;
		this.costOfWashingPowder = costOfWashingPowder;
	}

	@Override
	public String toString() {
		return "Laundry [numberOfCloths=" + numberOfCloths + ", timeRequired=" + timeRequired + ", totalCost="
				+ totalCost + ", waterUsed=" + waterUsed + ", electricityUsed=" + electricityUsed
				+ ", costOfWashingPowder=" + costOfWashingPowder + "]";
	}

	public int getNumberOfCloths() {
		return numberOfCloths;
	}

	public void setNumberOfCloths(int numberOfCloths) {
		this.numberOfCloths = numberOfCloths;
	}

	public float getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getWaterUsed() {
		return waterUsed;
	}

	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}

	public float getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public float getCostOfWashingPowder() {
		return costOfWashingPowder;
	}

	public void setCostOfWashingPowder(float costOfWashingPowder) {
		this.costOfWashingPowder = costOfWashingPowder;
	}
	
}


class WashingTub{
	private int capacity;
	private String type; //
	public WashingTub(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}
	@Override
	public String toString() {
		return "WashingTub [capacity=" + capacity + ", type=" + type + "]";
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}


class WashingPowder{ // isA

	private int quantity; // in grams
	private String brand;
	private String type;
	private boolean scented;
	private float price; // in rupees
	
	public WashingPowder(int quantity, String brand, String type, boolean scented, float price) {
		super();
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;
		this.scented = scented;
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "WashingPowder [quantity=" + quantity + ", brand=" + brand + ", type=" + type + ", scented=" + scented
				+ ", price=" + price + "]";
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isScented() {
		return scented;
	}

	public void setScented(boolean scented) {
		this.scented = scented;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}

class Water {
	private String type;
	private int quantity; // in liters
	private String temperature; // in deg Celsius
	
	public Water(String type, int quantity, String temperature) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Water [type=" + type + ", quantity=" + quantity + "L, temperature=" + temperature + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}

class Electricity {
	private String type; //ac dc
	private float voltage; // volts
	private int costPerUnit;
	private int unitUsed; // kWh
	private String supplier;
	
	public Electricity(String type, float voltage, int costPerUnit, int unitUsed, String supplier) {
		super();
		this.type = type;
		this.voltage = voltage;
		this.costPerUnit = costPerUnit;
		this.unitUsed = unitUsed;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", voltage=" + voltage + "V, costPerUnit=" + costPerUnit + ", unitUsed="
				+ unitUsed + "units, supplier=" + supplier + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public int getUnitUsed() {
		return unitUsed;
	}
	public void setUnitUsed(int unitUsed) {
		this.unitUsed = unitUsed;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}	
}

class Cloth {
	private String material; //
	private String color;
	private float cost;
	private String type;
	private boolean clean; //
	
	public Cloth(String material, String color, float cost, String type, boolean clean) {
		super();
		this.material = material;
		this.color = color;
		this.cost = cost;
		this.type = type;
		this.clean = clean;
	}
	@Override
	public String toString() {
		return "Cloth [material=" + material + ", color=" + color + ", cost=" + cost + ", type=" + type + ", clean="
				+ clean + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
}
