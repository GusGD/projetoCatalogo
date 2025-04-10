import React from "react";
import { Link, useLocation } from "react-router-dom";

export const Navbar = (): JSX.Element => {
  const location = useLocation();
  
  const navItems = [
    { name: "HOME", path: "/" },
    { name: "CATÁLOGO", path: "/catalog" },
    { name: "ADMIN", path: "/admin" },
  ];

  return (
    <header className="w-full h-[70px] bg-[#407bff] flex items-center px-10">
      <Link 
        to="/"
        className="font-['Open_Sans',Helvetica] font-bold text-white text-2xl tracking-[-0.36px]"
      >
        DS Catalog
      </Link>

      <nav className="flex gap-x-14 mx-auto">
        {navItems.map((item) => (
          <Link
            key={item.name}
            to={item.path}
            className={`font-['Open_Sans',Helvetica] text-lg text-center tracking-[-0.27px] ${
              location.pathname === item.path
                ? "font-bold text-white"
                : "font-semibold text-[#ffffff80]"
            }`}
          >
            {item.name}
          </Link>
        ))}
      </nav>
    </header>
  );
};