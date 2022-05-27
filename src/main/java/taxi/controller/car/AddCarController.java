package taxi.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Manufacturer;
import taxi.service.entity.CarService;
import taxi.service.entity.ManufacturerService;

public class AddCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getAllManufacturer(request);
        request.getRequestDispatcher("/WEB-INF/views/cars/add.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String model = request.getParameter("model");
        String idManufacturer = request.getParameter("manufacturer_id");
        Long manufacturerId = Long.parseLong(idManufacturer.substring(0, idManufacturer.indexOf(" ")));
        manufacturerService.get(manufacturerId);
        Manufacturer manufacturer = manufacturerService.get(manufacturerId);
        carService.create(new Car(model, manufacturer));
        request.setAttribute("successMsg", "Success");
        getAllManufacturer(request);
        request.getRequestDispatcher("/WEB-INF/views/cars/add.jsp").forward(request, response);
    }

    private void getAllManufacturer(HttpServletRequest request) {
        List<Manufacturer> allManufacturer = manufacturerService.getAll();
        request.setAttribute("manufacturers", allManufacturer);
    }
}
