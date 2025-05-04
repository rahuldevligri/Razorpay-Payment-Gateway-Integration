# Razorpay Payment Gateway Integration

A Spring Boot application demonstrating Razorpay payment gateway integration for processing payments and managing transaction records.

![Razorpay Integration Demo](https://avatars.githubusercontent.com/u/128212455?v=4)

## Features ✨
- Create Razorpay orders and process payments
- Store transaction details in database
- Simple HTML frontend for payment initiation
- Error handling for failed payments
- SweetAlert notifications for user feedback
- Invoice generation placeholder (to be implemented)

## Tech Stack 🛠️
- **Backend**: Java 17, Spring Boot 3.x
- **Frontend**: HTML, JavaScript, jQuery
- **Payment Gateway**: Razorpay SDK
- **Database**: JPA/H2 (or any JPA-compliant database)
- **Libraries**: Lombok, Jackson, SweetAlert

## Setup Instructions 🚀

### Prerequisites
- Java JDK 17+
- Maven/Gradle
- Razorpay Test API Keys
- Web browser with JavaScript enabled

### Configuration
1. Add Razorpay API keys in `application.properties`:
```properties
razorpay.key.id=your_rzp_test_key
razorpay.key.secret=your_rzp_test_secret
```

2. Update database configuration in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:paymentdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
```

### Installation
```bash
git clone https://github.com/your-username/razorpay-payment-integration.git
cd razorpay-payment-integration
mvn clean install
mvn spring-boot:run
```

## Usage 💻
- Access the payment page at `http://localhost:8080/payment`

- Enter amount in INR (e.g., 100.50)

- Click "Pay" to initiate payment

- Complete payment via Razorpay checkout

- View transaction success/failure alerts

## Payment Flow 🔄
- User enters payment amount

- System creates Razorpay order

- Payment details stored in database

- Razorpay checkout modal appears

- User completes payment

- Transaction status updated

## Database Schema 📊
```bash
CREATE TABLE razorpay (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(255),
    payment_id VARCHAR(255),
    amount FLOAT,
    currency VARCHAR(3),
    method VARCHAR(50),
    receipt VARCHAR(255),
    appointment_id VARCHAR(255),
    status VARCHAR(50),
    created_at VARCHAR(255)
);
```

## API Endpoints 🌐
- **GET /payment**: Render payment page

- **POST /payment**: Process payment request

- **Request Param**: amount (required)

## Security Notes 🔒
- Never commit actual API keys to version control

- Use HTTPS in production environments

- Implement proper input validation

- Add CSRF protection for production use

