package taxi.service.check.relation;

import java.util.List;
import taxi.lib.Injector;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.entity.CarService;
import taxi.service.entity.DriverService;

@Service
public class CheckRelationServiceImpl implements CheckRelationService {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    public boolean checkRelation(Long carId, Long driverId) {
        Driver driver = driverService.get(driverId);
        Car car = carService.get(carId);
        List<Car> allByDriver = carService.getAllByDriver(driverId);
        if (!allByDriver.contains(car)) {
            carService.addDriverToCar(driver, car);
            return true;
        }
        return false;
    }
}
