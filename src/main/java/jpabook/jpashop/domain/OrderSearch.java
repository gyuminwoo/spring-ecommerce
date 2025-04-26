package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName; //会員の名前
    private OrderStatus orderStatus; //注文の状態[ORDER, CANCEL]

}
