const inputId = document.getElementById('inputId');

inputId.addEventListener('input', function() {
    const inputValue = inputId.value;

    const regex = /^[a-z][a-zA-Z0-9]{5,13}$/;

    if (regex.test(inputValue)) {
        inputId.style.backgroundColor = 'green';
    } else {
        inputId.style.backgroundColor = 'red';
    }
});


// HTML에서 ID가 'password'인 비밀번호 입력 요소와 'confirmPassword'인 비밀번호 확인 입력 요소를 가정합니다.
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');

confirmPassword.addEventListener('keyup', function() {
    if (confirmPassword.value !== '' && password.value === '') {
        confirmPassword.value = '';
        alert('비밀번호를 입력해주세요.');
    }
});

confirmPassword.addEventListener('input', function() {
    const password = password.value;
    const confirmPassword = confirmPassword.value;

    if (password === confirmPassword) {
        // 비밀번호 일치 시 초록색으로 표시
        password.nextElementSibling.textContent = '비밀번호 일치';
        password.nextElementSibling.style.color = 'green';
    } else {
        // 비밀번호 불일치 시 빨간색으로 표시
        password.nextElementSibling.textContent = '비밀번호가 불일치';
        password.nextElementSibling.style.color = 'red';
    }
});


const name = document.getElementById('name');

name.addEventListener('input', function() {
    const nameValue = name.value;
    const regex = /^[가-힣]{2,5}$/;

    if (regex.test(nameValue)) {
        // 형식이 일치할 경우
        name.nextElementSibling.textContent = '정상입력';
        name.nextElementSibling.style.color = 'green';
    } else {
        // 형식이 일치하지 않을 경우
        name.nextElementSibling.textContent = '한글만 입력하세요';
        name.nextElementSibling.style.color = 'red';
    }
});