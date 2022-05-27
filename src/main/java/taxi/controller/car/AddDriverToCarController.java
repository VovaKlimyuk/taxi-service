package taxi.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.service.check.relation.CheckRelationService;
import taxi.service.entity.CarService;

public class AddDriverToCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final CheckRelationService checkRelation =
            (CheckRelationService) injector.getInstance(CheckRelationService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getAllCar(request);
        request.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String idCar = request.getParameter("car_id");
        Long carId = Long.parseLong(idCar.substring(0, idCar.indexOf(" ")));
        Long driverId = (Long) request.getSession().getAttribute("driver_id");
        if (!checkRelation.checkRelation(carId, driverId)) {
            request.setAttribute("errorMsg", "Can't add driver to car");
            getAllCar(request);
            request.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("successMsg", "Success");
        getAllCar(request);
        request.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp")
                .forward(request, response);
    }

    private void getAllCar(HttpServletRequest request) {
        List<Car> allCars = carService.getAll();
        request.setAttribute("cars", allCars);
    }
}
