# Minh chứng sử dụng AI viết Unit Test (JUnit 5) - SOF309

## 1. Thông tin chung
- **Mục tiêu:** Xây dựng bộ kiểm thử đơn vị (Unit Test) cho chức năng xác thực tài khoản (`AuthControllerTest.java`).
- **Kỹ thuật áp dụng:** Parameterized Test (`@CsvSource`), Exception Testing (`assertThrows`), Timeout Testing (`@Timeout`).

## 2. Prompt sử dụng
> "Viết class JUnit 5 test cho AuthService trong Java với 3 kịch bản: 
> 1. Dùng @ParameterizedTest và @CsvSource để kiểm tra biên dữ liệu đầu vào của hàm validateRegister(username, password) gồm các trường hợp: rỗng, dưới 5 ký tự, mật khẩu dưới 8 ký tự và hợp lệ.
> 2. Dùng assertThrows để kiểm tra ngoại lệ DuplicateUserException khi đăng ký trùng tài khoản 'admin'.
> 3. Dùng @Timeout giới hạn 2 giây để đảm bảo hàm xử lý dữ liệu không bị treo."

## 3. Kết quả thực thi
- Toàn bộ 6 test cases (4 cases từ `@CsvSource`, 1 case Exception, 1 case Timeout) đều chạy thành công (`PASSED`) trên IntelliJ IDEA.