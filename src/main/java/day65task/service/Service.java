package day65task.service;

import day65task.model.dto.OrderDto;
import day65task.model.entity.OrderEntity;
import day65task.model.entity.ProductEntity;
import day65task.model.entity.UserEntity;
import day65task.model.repository.CategoryRepository;
import day65task.model.repository.OrderRepository;
import day65task.model.repository.ProductRepository;
import day65task.model.repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public boolean order(OrderDto orderDto) {
        int loginUno = 1;
        Optional<UserEntity> optionalUser = userRepository.findById(loginUno);
        if (optionalUser.isPresent()==false){return false;}
        UserEntity loginEntity = optionalUser.get();

        int selectPno = 1;
        Optional<ProductEntity> optionalProduct = productRepository.findById(selectPno);
        if (optionalProduct.isPresent()==false){return false;}
        ProductEntity selectEntity = optionalProduct.get();

        orderDto.setOstate("결제 전");
        orderDto.setOamount((selectEntity.getPprice()*orderDto.getOquantity()));
        OrderEntity orderEntity = orderDto.toEntity();
        orderEntity.setUserEntity(loginEntity);
        orderEntity.setProductEntity(selectEntity);

        OrderEntity saveEntity = orderRepository.save(orderEntity);
        if (saveEntity.getOno()>0){return true;}
        return false;
    }

    public List<OrderDto> mylist(int uno) {
        Optional<UserEntity> optionalUser = userRepository.findById(uno);
        if (optionalUser.isPresent()){
            UserEntity orderUser = optionalUser.get();

            List<OrderEntity> orderEntityList = orderUser.getOrderEntityList();

            List<OrderDto> orderDtoList = orderEntityList.stream().map(OrderEntity::toDto).collect(Collectors.toList());
            return orderDtoList;
        }
        return null;
    }

}
