import React from 'react';
import { Component } from "react";
import { observer, inject } from 'mobx-react';
import TextField from '@material-ui/core/TextField';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import FormLabel from '@material-ui/core/FormLabel';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import RadioGroup from '@material-ui/core/RadioGroup';
import Radio from '@material-ui/core/Radio';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    height: '100%',
    width: 500,
    margin: 10,
  },
  field: {
    marginTop: '100%',
    width: '90%',
    height: '10%',
  }
});


@inject('stores')
@observer
class Meet extends Component{
  constructor(props) {
    super(props);
    this.state = {
      spacing : 2
    }
  }

  render() {

    const { classes } = this.props;

    const layout = (
      <Grid container className={classes.root} spacing={2}>
      <Grid item xs={12}>
        <Grid container justify="center" spacing={this.spacing}>
          {/* {[0, 1, 2].map(value => ( */}
            <Grid item >
              <Paper className={classes.paper}>
                화상채팅
              </Paper>
            </Grid>
            <Grid item>
              <Paper className={classes.paper}>
                <div>
                  chatting
                </div>
              <TextField
                className={classes.field}
                id="outlined-full-width"
                label="Chat"
                placeholder="Placeholder"
                // fullWidth
                margin="normal"
                variant="outlined"
                InputLabelProps={{
                  shrink: true,
                }}
              />
                </Paper>
            </Grid>
          {/* ))} */}
        </Grid>
      </Grid>
      
    </Grid>
    );

      
    return (
      
      <div>
          "Meet" page <br/>
          {layout}
          
      </div>
    );
  }
}



// export default Meet;
export default withStyles(styles)(Meet);
