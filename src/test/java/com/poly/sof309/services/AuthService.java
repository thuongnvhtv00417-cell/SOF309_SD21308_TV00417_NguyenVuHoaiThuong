package com.poly.sof309.services;

import com.poly.sof309.exceptions.DuplicateUserException;

public class AuthService {

    // Hàm cho Bước 2.2
    public boolean validateRegister(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (username.length() < 5 || username.length() > 20) {
            return false;
        }
        if (password == null || password.length() < 8) {
            return false;
        }
        return true;
    }

    // Hàm cho Bước 2.3
    public void registerExistingAccount(String username) {
        if ("admin".equalsIgnoreCase(username)) {
            throw new DuplicateUserException("Tài khoản đã tồn tại trong hệ thống!");
        }
    }

    // Hàm cho Bước 2.4
    public void processLargeDataset() {
        try {
            // Giả lập xử lý dữ liệu mất 500ms (nhỏ hơn giới hạn 2 giây)
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}