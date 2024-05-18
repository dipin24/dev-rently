function showLogin() {
    document.getElementById('login-register').innerHTML = `
        <h2>Login</h2>
        <form id="loginForm">
            <input type="email" id="email" placeholder="Email" required><br>
            <input type="password" id="password" placeholder="Password" required><br>
            <button type="submit">Login</button>
        </form>
    `;
    document.getElementById('loginForm').addEventListener('submit', loginUser);
}

function showRegister() {
    document.getElementById('login-register').innerHTML = `
        <h2>Register</h2>
        <form id="registerForm">
            <input type="text" id="firstName" placeholder="First Name" required><br>
            <input type="text" id="lastName" placeholder="Last Name" required><br>
            <input type="email" id="email" placeholder="Email" required><br>
            <input type="password" id="password" placeholder="Password" required><br>
            <input type="text" id="phoneNumber" placeholder="Phone Number" required><br>
            <select id="role" required>
                <option value="">Select Role</option>
                <option value="buyer">Buyer</option>
                <option value="seller">Seller</option>
            </select><br>
            <button type="submit">Register</button>
        </form>
    `;
    document.getElementById('registerForm').addEventListener('submit', registerUser);
}

function loginUser(event) {
    event.preventDefault();
    // Handle login functionality
}

function registerUser(event) {
    event.preventDefault();
    // Handle registration functionality
}

document.addEventListener('DOMContentLoaded', () => {
    // Fetch properties and display them
});
