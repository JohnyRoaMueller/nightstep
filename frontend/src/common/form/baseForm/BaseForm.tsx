import { FormEvent } from "react"
import { FormContainer } from "./BaseForm.Styles"
import BaseFormProps from "./BaseForm.Types"
import { Button } from "@mui/material"



function BaseForm( { children, onSubmit, ...boxProps } : BaseFormProps) {
    return(
        <>
        <FormContainer {...boxProps}>
            <form typeof="submit" onSubmit={onSubmit}>
                {children}
            </form>
        </FormContainer>
        </>
    )
}

export default BaseForm