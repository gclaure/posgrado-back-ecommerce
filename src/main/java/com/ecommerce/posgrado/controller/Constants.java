package com.ecommerce.posgrado.controller;

/**
 * @author gclaure from CochaSoft
 * Date: 5/20/23
 * Time: 23:41
 * Project Name: posgrado
 */
public class Constants {

    public Constants() {
    }

    public static final class user {
        public static final String PATH = "/api/v1/user";
        public static final String NAME = "Service User";
    }

    public static final class category {
        public static final String PATH = "/api/v1/category";
        public static final String NAME = "Service Category";
    }

    public static final class role {
        public static final String PATH = "/api/v1/role";
        public static final String NAME = "Service Role";
    }

    public static final class product {
        public static final String PATH = "/api/v1/product";
        public static final String NAME = "Service Product";
    }

    public static final class order {
        public static final String PATH = "/api/v1/order";
        public static final String NAME = "Service Order";
    }

    public static final class auth {
        public static final String PATH = "/api/v1/auth";
        public static final String NAME = "Service Auth";
    }

    public static final class security {
        public static final String AUTHORIZATION = "Bearer-Token";
    }
}
