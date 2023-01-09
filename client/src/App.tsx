import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './App.css';
import Header from 'Components/Header';
import Main from 'Pages/Main';
import Loding from 'Components/Loding';
import Login from 'Pages/Login';
import Signup from 'Pages/Signup';
const withLayout = (Component: React.FC): JSX.Element => {
  return (
    <>
      <Header />
      <Component />
    </>
  );
};

const router = createBrowserRouter([
  {
    path: '/',
    element: withLayout(Main),
    errorElement: <Loding />,
  },
  {
    path: '/login',
    element: <Login />,
  },
  {
    path: '/signup',
    element: <Signup />,
  },
]);

const App: React.FC = () => {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
};

export default App;
