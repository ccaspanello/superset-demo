import {Menubar} from "primereact/menubar";
import {MenuItem} from "primereact/menuitem";
import {useNavigate} from "react-router-dom";
import {routes} from "../AppRoutes.tsx";

const Header = () => {

  const navigate = useNavigate();

  const mainMenu: MenuItem[] =[
    {
      label: "Home",
      command: () => navigate(routes.home),
    },
    {
      label: "Starbucks",
      command: () => navigate(routes.starbucks),
    }
  ]

  return (
    <Menubar model={mainMenu} />
  )
}
export default Header;