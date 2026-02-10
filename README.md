# REQUIREMENT WEBSITE TUYỂN DỤNG VIỆC LÀM

*(Xây dựng dựa trên thiết kế CSDL hiện tại)*

---

## 1. Tổng quan dự án

### 1.1. Tên dự án

**Job Recruitment Website – Website Tuyển Dụng Việc Làm**

### 1.2. Mục tiêu

Xây dựng một hệ thống website tuyển dụng việc làm cho phép:

* Nhà tuyển dụng đăng tin tuyển dụng, quản lý hồ sơ ứng viên
* Ứng viên tìm kiếm việc làm, nộp hồ sơ và theo dõi trạng thái ứng tuyển
* Hệ thống hỗ trợ **realtime**: thông báo, chat, trạng thái online

### 1.3. Đối tượng sử dụng

* Khách truy cập (Guest)
* Ứng viên (Candidate)
* Nhà tuyển dụng (Employer)
* Quản trị viên (Admin)

---

## 2. Công nghệ sử dụng

* **Backend:** Node.js (Express.js)
* **Cơ sở dữ liệu:** MySQL
* **Quản lý CSDL:** HeidiSQL (chạy trên Laragon)
* **Frontend:** HTML, CSS, JavaScript
* **Xác thực:** Local Auth & Google OAuth
* **Kiến trúc:** RESTful API + MVC

---

## 3. Phân quyền hệ thống

| Vai trò   | Mô tả                     |
| --------- | ------------------------- |
| ADMIN     | Quản trị toàn bộ hệ thống |
| EMPLOYER  | Nhà tuyển dụng            |
| CANDIDATE | Ứng viên                  |

---

## 4. Chức năng hệ thống

### 4.1. Chức năng cho Khách truy cập (Guest)

* Xem danh sách việc làm đang mở
* Tìm kiếm việc làm theo:

  * Từ khóa
  * Thành phố
  * Mức lương
  * Ngành nghề
* Xem chi tiết tin tuyển dụng
* Đăng ký / Đăng nhập hệ thống

---

### 4.2. Chức năng cho Người dùng (Users)

#### 4.2.1. Đăng ký & Đăng nhập

* Đăng ký bằng email & mật khẩu
* Đăng nhập bằng Google OAuth
* Phân biệt loại tài khoản: Ứng viên / Nhà tuyển dụng
* Quản lý trạng thái tài khoản: Active / Inactive / Banned

#### 4.2.2. Quản lý hồ sơ cá nhân

* Cập nhật thông tin cá nhân
* Cập nhật ảnh đại diện
* Theo dõi trạng thái online / offline

---

### 4.3. Chức năng cho Ứng viên (Candidate)

* Tạo và cập nhật hồ sơ ứng viên:

  * Thông tin cá nhân
  * Trình độ học vấn
  * Kinh nghiệm làm việc
  * Mức lương mong muốn
  * Upload CV
* Quản lý kỹ năng cá nhân
* Tìm kiếm và lưu công việc yêu thích
* Nộp hồ sơ ứng tuyển
* Theo dõi trạng thái đơn ứng tuyển:

  * Pending, Reviewed, Interview, Accepted, Rejected
* Nhận thông báo realtime khi có cập nhật

---

### 4.4. Chức năng cho Nhà tuyển dụng (Employer)

* Quản lý hồ sơ công ty:

  * Tên công ty, logo, mô tả
  * Quy mô, lĩnh vực, địa chỉ
* Đăng tin tuyển dụng:

  * Tiêu đề, mô tả, yêu cầu
  * Hình thức làm việc, cấp bậc
  * Mức lương, địa điểm, deadline
* Quản lý kỹ năng yêu cầu cho công việc
* Quản lý đơn ứng tuyển:

  * Xem danh sách ứng viên
  * Duyệt / từ chối / mời phỏng vấn
* Nhận thông báo realtime khi có ứng viên mới

---

### 4.5. Chức năng cho Quản trị viên (Admin)

* Quản lý tài khoản người dùng
* Duyệt nhà tuyển dụng
* Quản lý danh mục ngành nghề
* Quản lý kỹ năng hệ thống
* Theo dõi lịch sử hoạt động người dùng
* Xem thống kê tổng quan hệ thống

---

## 5. Chức năng Realtime

* Thông báo realtime khi:

  * Có đơn ứng tuyển mới
  * Trạng thái đơn ứng tuyển thay đổi
* Chat realtime giữa Nhà tuyển dụng và Ứng viên
* Theo dõi trạng thái online của người dùng

---

## 6. Yêu cầu chức năng (Functional Requirements)

* FR-01: Người dùng có thể đăng ký và đăng nhập bằng Local hoặc Google
* FR-02: Ứng viên có thể nộp hồ sơ cho mỗi công việc tối đa một lần
* FR-03: Nhà tuyển dụng có thể quản lý tin tuyển dụng của mình
* FR-04: Hệ thống tự động tạo thông báo khi có sự kiện quan trọng
* FR-05: Hệ thống hỗ trợ tìm kiếm toàn văn (Full-text search)

---

## 7. Yêu cầu phi chức năng (Non-Functional Requirements)

* Thời gian phản hồi < 3 giây
* Mật khẩu được mã hóa
* Dữ liệu đảm bảo toàn vẹn (ràng buộc khóa ngoại)
* Code rõ ràng, dễ mở rộng
* Phù hợp quy mô đồ án môn học

---

## 8. Yêu cầu cơ sở dữ liệu

Hệ thống sử dụng các bảng chính:

* users, employers, candidates
* jobs, categories, skills
* applications, saved_jobs
* notifications, messages
* activity_logs

Hỗ trợ:

* Trigger tự động
* Stored Procedure
* View tổng hợp dữ liệu

---

## 9. Phạm vi dự án

* Không tích hợp thanh toán
* Không triển khai AI gợi ý nâng cao
* Tập trung vào nghiệp vụ tuyển dụng cốt lõi

---

## 10. Kết luận

Requirement được xây dựng phù hợp với thiết kế cơ sở dữ liệu hiện tại, đảm bảo tính đầy đủ nghiệp vụ, hỗ trợ realtime và phù hợp để triển khai bằng Node.js và MySQL trong khuôn khổ đồ án môn học.
