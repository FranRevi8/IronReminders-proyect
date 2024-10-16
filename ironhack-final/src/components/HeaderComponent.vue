<script setup>
import router from '@/router'

const logout = () => {
  sessionStorage.removeItem('authToken')
  router.push('/api/login')
}
</script>

<template>
  <div class="header-container">
    <header>
      <div class="logo1"></div>
      <div class="logo2"></div>
      <div class="logo3"></div>
      <div class="logo4"></div>
      <h1>Iron Reminders</h1>
      <div class="logo-finisher"></div>
      <nav>
        <ul>
          <li><a @click="logout">Cerrar Sesión</a></li>
        </ul>
      </nav>
    </header>
  </div>
</template>

<style scoped>
.header-container {
  background: linear-gradient(to bottom, #2c3e50, #1e3042);
  padding: 15px 0;
  position: fixed;
  width: 100%;
  z-index: 1;
}

header {
  width: 94%;
  height: 50px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo1 {
  position: absolute;
  left: 12vw;
  background-color: #ffb3ba;
  width: 0.8vw;
  height: 150px;
  transform: rotate(30deg);
}

.logo2 {
  position: absolute;
  left: 12.8vw;
  background-color: #ffdfba;
  width: 0.8vw;
  height: 150px;
  transform: rotate(30deg);
}

.logo3 {
  position: absolute;
  left: 13.6vw;
  background-color: #ffffba;
  width: 0.8vw;
  height: 150px;
  transform: rotate(30deg);
}

.logo4 {
  position: absolute;
  left: 14.4vw;
  background-color: #baffc9;
  width: 0.8vw;
  height: 150px;
  transform: rotate(30deg);
}

.logo-finisher {
  height: 40px;
  width: 15vw;
  background-color: #34495e;
  z-index: 2;
  position: fixed;
  left: 0;
  top: 80px;
}

h1 {
  font-size: 2rem;
  color: #e7eef0;
  z-index: 1;
  text-shadow:
    -1.5px -1.5px 0 black,
    1.5px -1.5px 0 black,
    -1.5px 1.5px 0 black,
    1.5px 1.5px 0 black;
}

nav ul {
  display: flex;
  list-style-type: none;
}

nav ul li {
  margin-left: 20px;
}

nav ul li a {
  text-decoration: none;
  color: #ecf0f1;
  cursor: pointer;
}

nav ul li a:hover {
  color: #3498db;
}

@media (max-width: 810px) {
  header {
    height: 40px;
  }

  h1 {
    font-size: 24px;
  }

  .logo-finisher {
    height: 50px;
    top: 70px;
  }

  nav ul li a {
    font-size: 14px;
  }
}

@media (max-width: 630px) {
  header {
    height: 30px;
  }

  h1 {
    font-size: 22px;
  }

  .logo-finisher {
    height: 60px;
    top: 60px;
  }

  nav ul li a {
    font-size: 12px;
  }
}
</style>
