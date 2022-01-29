package com.revature.utils;

import io.javalin.core.security.RouteRole;

public enum Role implements RouteRole {
    BASE, CUSTOMER, EMPLOYEE, MANAGER
}
