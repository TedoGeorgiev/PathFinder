package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private Random random;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.random = new Random();
    }

    @Override
    @Transactional
    public RouteShortInfoDTO getRandomRoute () {

        long count = routeRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);

        Optional<Route> route = routeRepository.findById(randomId);
        if (route.isEmpty()) {
            throw new IllegalArgumentException("no route found");
        }

        return mapToShortInfo(route.get());
    }

    @Override
    @Transactional
    public List<RouteShortInfoDTO> getAll() {

        return this.routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .collect(Collectors.toList());
    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {

        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);
        Optional<Picture> imageUrl = route.getPictures().stream().findFirst();
        dto.setImageUrl(imageUrl.get().getUrl());

        return dto;

    }

}
