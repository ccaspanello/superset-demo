import {embedDashboard} from "@superset-ui/embedded-sdk";
import {useEffect} from "react";
import axios from "axios";

interface DashboardProps{
  dashboardId: string
  filters?: {
    [key: string]: boolean | undefined
    visible?: boolean
    expanded?: boolean
  }
}
const Dashboard = (props: DashboardProps) => {

  useEffect(() => {
    const mountPoint = document.getElementById("dashboard") as HTMLElement;
    const embed = async () => {
      await embedDashboard({
        id: props.dashboardId, // given by the Superset embedding UI
        supersetDomain: "http://localhost:8088",
        mountPoint: mountPoint, // html element in which iframe render
        fetchGuestToken: () => getToken(),
        dashboardUiConfig: {
          hideTitle: false,
          hideChartControls: false,
          hideTab: true,
          filters: props.filters
        },
      })
    }
    if (mountPoint) {
      embed()
      mountPoint.firstElementChild?.classList.add("w-full", "border-none", "h-full");
    }
  }, [])

  const getToken = async () => {
    const response = await axios.get("/api/token/"+props.dashboardId)
    return response.data.token;
  }

  return (
      <div id="dashboard" className="flex-grow-1"></div>
  )
}

export default Dashboard;