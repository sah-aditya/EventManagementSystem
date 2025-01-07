document.getElementById('loginForm')?.addEventListener('submit', function (e) {
    e.preventDefault();
    alert('Login successful!');
});

document.getElementById('registerForm')?.addEventListener('submit', function (e) {
    e.preventDefault();
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    if (password !== confirmPassword) {
        alert('Passwords do not match!');
    } else {
        alert('Registration successful!');
    }
});
