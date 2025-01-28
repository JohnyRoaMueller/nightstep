import { colors } from "@mui/material";
import zIndex from "@mui/material/styles/zIndex";
import theme from "../../../theme/theme";




export const registerHostFormContainer = {
    width: '40%',

    zIndex: '1',

    padding: '50px',

    alignItems: 'center',

    border: '0.2em solid',
    borderRadius: '10%',
    
    // theme styling
    backgroundColor: (theme) => theme.palette.background.paper
}

export const registerHostFormButton = {
    backgroundColor : (theme) => theme.palette.primary.main,
}

export const registerHostFormButtonTypography = {
    color: 'black'
}

export const registerHostFormHeaderBox = {
    display: 'flex', 
    flexDirection: 'column', 
    justifyContent: 'center', 
    alignItems: 'center', 
    textAlign: 'center',

    border: '0.2em solid',
    borderRadius: '2em',
    
    backgroundColor: (theme) => theme.palette.background.default
}

export const registerHostFormHeaderTypo = {
    color: 'black'
}

