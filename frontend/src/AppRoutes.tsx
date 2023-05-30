import {Route, Routes} from "react-router-dom";
import BasicPage from "./pages/BasicPage.jsx";
import StarbucksPage from "./pages/StarbucksPage.tsx";

export const routes = {
  home: '/',
  starbucks: '/starbucks',
}

function AppRoutes() {

  return (
      <Routes>
        <Route path={routes.home} element={<BasicPage/>} />
        <Route path={routes.starbucks} element={<StarbucksPage/>} />
      </Routes>
  )
}

export default AppRoutes
