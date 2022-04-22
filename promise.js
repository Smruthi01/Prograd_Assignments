// let myPromise = new Promise(function(myResolve, myReject) {
//     myResolve("Second");
// })
// myPromise.then(function(result){
//     console.log(result);
// })
// async function abc() {
//    // await myPromise;
//     console.log("Third");//exe 2nd
// }


// abc().then(
// function (value) {console.log(value);},
// function (err) {console.log(err);}
// );

console.log("Firstttt");//executed very 1st

//abc();


// s=1;
// let SPromise = new Promise(function(myResolve, myReject) {
//     // "Producing Code" (May take some time)
    
//       myResolve("Promised"); // when successful
//       myReject("Nopromise");  // when error
//     });
    
//     // "Consuming Code" (Must wait for a fulfilled Promise)
//     myPromise.then(
//       function(s=1) {console.log("done") /* code if successful */ },
//       function(s=0) { console.log("fail")/* code if some error */ }
//     );