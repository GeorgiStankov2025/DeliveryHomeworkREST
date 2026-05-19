package pu.fmi.webprogramming.repository;

import org.springframework.stereotype.Repository;
import pu.fmi.webprogramming.model.Courier;
import pu.fmi.webprogramming.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourierRepository {

  private List<Courier> couriers = new ArrayList<>();

  public CourierRepository() {
    couriers.add(new Courier(1L,"Ivan", "Ivanov", true, "Plovdiv"));
    couriers.add(new Courier(2L, "Dragan", "Petkanov", true, "Sofia"));
  }

  public Courier findAvailableCourier() {
    Courier availableCourier =
        couriers.stream()
                .filter(courier -> courier.isAvailable())
                .findFirst()
                .orElse(null);

    return availableCourier;
  }

  //Добавих метод, който търси куриер по Id

  public Courier findById(Long id) {
      Courier courierFound=couriers.stream()
              .filter(courier -> courier.getId().equals(id))
              .findFirst()
              .orElse(null);
      return courierFound;
  }

  public List<Courier> getAllCouriers() {
    return couriers;
  }
}
