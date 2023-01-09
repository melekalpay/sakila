package com.uniyaz.staff;

import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.service.StaffService;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.service.StoreService;
import org.junit.Test;

import java.util.List;

public class StaffServiceTest {
    @Test
    public void findAllTest() {

        StaffService staffService = new StaffService();
        List<Staff> staffList = staffService.findAll();
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
}
