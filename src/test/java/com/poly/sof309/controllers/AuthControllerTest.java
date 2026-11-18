package com.poly.sof309.controllers;

import com.poly.sof309.exceptions.DuplicateUserException;
import com.poly.sof309.services.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthControllerTest {

    private AuthService authService;

    @BeforeEach
    public void setUp() {
        authService = new AuthService();
    }

    // Bước 2.2: Parameterized Test kiểm tra biên form
    @ParameterizedTest
    @DisplayName("Kiểm tra validation đăng ký tài khoản với nhiều bộ dữ liệu biên")
    @CsvSource({
        "'', 'password123', false, 'Username không được để trống'",
        "'user', 'password123', false, 'Username phải từ 5 đến 20 ký tự'",
        "'validUser', '123', false, 'Mật khẩu phải từ 8 ký tự'",
        "'validUser', 'Pass@1234', true, 'Đăng ký thành công'"
    })
    public void testRegisterValidation(String username, String password, boolean expectedSuccess, String message) {
        boolean actualResult = authService.validateRegister(username, password);
        assertEquals(expectedSuccess, actualResult, message);
    }

    // Bước 2.3: Exception Testing
    @Test
    @DisplayName("Ném ngoại lệ DuplicateUserException khi tài khoản đã tồn tại")
    public void testRegisterDuplicateUserThrowsException() {
        assertThrows(DuplicateUserException.class, () -> {
            authService.registerExistingAccount("admin");
        });
    }

    // Bước 2.4: Timeout Testing
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @DisplayName("Kiểm tra hàm xử lý dữ liệu không bị treo vòng lặp vô tận")
    public void testProcessDataTimeout() {
        authService.processLargeDataset();
    }
}