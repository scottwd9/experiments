function trailingStop(price, stop_percent) {
  var stop = price - price * stop_percent/100;
  stop = Math.round(stop * 100) / 100
  var limit = stop - 0.25
  return {
    stop: stop,
    limit: limit
  }
}
