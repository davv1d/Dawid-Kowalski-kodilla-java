package com.kodilla.good.patterns.challenges.exercise2;

public class ProductOrderService {
    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public ProductOrderService(final InformationService informationService,
                               final RentalService rentalService,
                               final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest) {
        boolean isRented = rentalService.rent(rentRequest);

        if(isRented) {
            informationService.inform(rentRequest.getUser(), rentRequest.getThing());
            rentalRepository.createRental(rentRequest);
            return new RentalDto(rentRequest.getUser(), true);
        } else {
            return new RentalDto(rentRequest.getUser(), false);
        }
    }

}
