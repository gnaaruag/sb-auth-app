import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { API_ENDPOINT } from "../config/constants";

interface UserData {
  id: {
    timestamp: number;
    date: string;
  };
  name: string;
  username: string;
  email: string;
  password: string;
}

const UserInfo: React.FC = () => {
  const [userData, setUserData] = useState<UserData>({
    id: {
      timestamp: 0,
      date: "",
    },
    name: "",
    username: "",
    email: "",
    password: "",
  });
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      if (!isAuthenticated) {
        navigate("/");
      }
      try {
        const response = await fetch(
          API_ENDPOINT + "/user/" +localStorage.getItem("username"),
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        if (response.ok) {
          const data: UserData = await response.json();
          setUserData(data);
        } else {
          console.error("Failed to fetch user data");
        }
      } catch (error) {
        console.error("Error occurred while fetching user data:", error);
      }
    };

    fetchData();
  });

  const handleLogout = () => {
    localStorage.removeItem("authentication");
    localStorage.removeItem("username");
    navigate("/");
  };

  // Check if authentication is true in localStorage
  const isAuthenticated = localStorage.getItem("authentication") === "true";

  // Render the component only if authenticated

  return (
    <div>
      <h2>User Info</h2>
      <div>
        <p>Name: {userData.name}</p>
        <p>Username: {userData.username}</p>
        <button onClick={handleLogout}>Logout</button>
      </div>
    </div>
  );
};

export default UserInfo;
