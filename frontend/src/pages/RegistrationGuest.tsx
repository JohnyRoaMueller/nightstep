import { Box } from "@mui/material";
import Base from "../components/base/base";
import RegisterGuestForm from "../components/form/registerGuestForm/RegisterGuestForm";





export default function Test() {


    return (
      <Base children={
        <>
                {/* ↓↓↓ My Content ↓↓↓ */}
                <RegisterGuestForm/>
                {/* ↑↑↑ My Content ↑↑↑ */}
                </>
            }>
            </Base>
    )
}