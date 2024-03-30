import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Signup from "./components/signup";
import Signin from "./components/signin";
import UserInfo from "./components/userinfo";
import NotFound from "./components/notfound";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Signup />,
  },
  {
    path: "/signin",
    element: <Signin />,
  },
  {
    path: "/user",
    element: <UserInfo />,
  },
  {
    path: "*",
    element: <NotFound />,
  },
])

const App = () => {
  return <RouterProvider router={router} />;
};

export default App;